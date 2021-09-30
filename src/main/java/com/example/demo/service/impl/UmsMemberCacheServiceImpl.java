package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.UmsMemberMapper;
import com.example.demo.mbg.model.UmsMember;
import com.example.demo.service.RedisService;
import com.example.demo.service.UmsMemberCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsMemberMapper umsMemberMapper;
    @Value("${spring.redis.database}")
    private String REDIS_DATABASE;
    @Value("${spring.redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${spring.redis.expire.authCode}")
    private String REDIS_EXPIRE_AUTH_CODE;
    @Value("${spring.redis.key.member}")
    private String REDIS_KEY_MEMBER;
    @Value("${spring.redis.key.authCode}")
    private String REDIS_KEY_AUTH_CODE;

    @Override
    public void delMember(Long memberId) {
        UmsMember umsMember = umsMemberMapper.selectByPrimaryKey(memberId).get();
        if (umsMember != null){
            String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + umsMember.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public UmsMember getMember(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + username;
        return (UmsMember) redisService.get(key);
    }

    @Override
    public void setMember(UmsMember umsMember) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + umsMember.getUsername();
        redisService.set(key, umsMember, REDIS_EXPIRE);
    }

    @Override
    public void setAuthCode(String telephone, String authCode) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" +telephone;
        redisService.set(key, authCode, REDIS_EXPIRE);
    }

    @Override
    public String getAuthCode(String telephone) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" +telephone;
        return (String) redisService.get(key);
    }
}
