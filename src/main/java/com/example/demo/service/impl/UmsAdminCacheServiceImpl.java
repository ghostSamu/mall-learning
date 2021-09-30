package com.example.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.example.demo.annotation.CacheException;
import com.example.demo.dao.UmsAdminRoleRelationDao;
import com.example.demo.mbg.mapper.UmsAdminDynamicSqlSupport;
import com.example.demo.mbg.mapper.UmsAdminRoleRelationDynamicSqlSupport;
import com.example.demo.mbg.mapper.UmsAdminRoleRelationMapper;
import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsAdminRoleRelation;
import com.example.demo.mbg.model.UmsResource;
import com.example.demo.service.RedisService;
import com.example.demo.service.UmsAdminCacheService;
import com.example.demo.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;


@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private RedisService redisService;
    @Value("${spring.redis.database}")
    private String REDIS_DATABASE;
    @Value("${spring.redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${spring.redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${spring.redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;


    @Override
    public void delAdmin(Long adminId) {
        UmsAdmin umsAdmin = umsAdminService.getItem(adminId);
        if (umsAdmin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + umsAdmin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" +adminId;
        redisService.del(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        List<UmsAdminRoleRelation> relationList = umsAdminRoleRelationMapper.select(c -> c.where(UmsAdminRoleRelationDynamicSqlSupport.roleId,isEqualTo(roleId)));
        if (CollUtil.isNotEmpty(relationList)){
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByRoles(List<Long> roleIds) {
        List<UmsAdminRoleRelation> relationList = umsAdminRoleRelationMapper.select(c -> c.where(UmsAdminRoleRelationDynamicSqlSupport.roleId,isIn(roleIds)));
        if (CollUtil.isNotEmpty(relationList)){
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        List<Long> adminIdList = umsAdminRoleRelationDao.getAdminIdList(resourceId);
        if (CollUtil.isNotEmpty(adminIdList)){
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = adminIdList.stream().map(adminId -> keyPrefix +adminId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @CacheException
    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin umsAdmin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + umsAdmin.getUsername();
        redisService.set(key, umsAdmin, REDIS_EXPIRE);
    }

    @Override
    public List<UmsResource> getResource(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<UmsResource>)redisService.get(key);
    }

    @Override
    public void setResource(Long adminId, UmsResource umsResource) {
        String key = REDIS_DATABASE + ":" +REDIS_KEY_RESOURCE_LIST + ":" +adminId;
        redisService.set(key, umsResource, REDIS_EXPIRE);
    }
}
