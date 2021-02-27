package com.example.demo.service.impl;

import com.example.demo.common.api.CommonResult;
import com.example.demo.service.RedisService;
import com.example.demo.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KYE_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

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
