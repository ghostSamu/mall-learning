package com.example.demo.service.impl;

import com.example.demo.common.api.CommonResult;
import com.example.demo.common.exception.Asserts;
import com.example.demo.mbg.mapper.UmsMemberDynamicSqlSupport;
import com.example.demo.mbg.mapper.UmsMemberMapper;
import com.example.demo.mbg.model.UmsMember;
import com.example.demo.service.RedisService;
import com.example.demo.service.UmsMemberService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KYE_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;


    @Override
    public void register(String username, String password, String telephone, String authCode){
        SelectStatementProvider selectStatement = SqlBuilder.select(UmsMemberMapper.selectList)
                .from(UmsMemberDynamicSqlSupport.umsMember)
                .where(UmsMemberDynamicSqlSupport.username, isEqualToWhenPresent(username))
                .or(UmsMemberDynamicSqlSupport.password, isEqualToWhenPresent(telephone))
                .build()
                .render(RenderingStrategy.MYBATIS3);
        List<UmsMember> umsMembers = memberMapper.selectMany(selectStatement);
        if (!CollectionUtils.isEmpty(umsMembers)){
            Asserts.fail("该用户已经存在");
        }
        //添加用户
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPassword(password);
        umsMember.setPhone(telephone);
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        memberMapper.insert(umsMember);
    }


    @Override
    public CommonResult getAuthCode(String telephone) {
        //生成验证码
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<6; i++ ){
            sb.append(random.nextInt(10));
        }

        redisService.set(REDIS_KYE_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KYE_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);

        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {

        if (StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KYE_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(authCode);
        if (result){
            return CommonResult.success(null, "验证码校验成功");
        }else {
            return CommonResult.failed("验证码校验不正确");
        }
    }
}
