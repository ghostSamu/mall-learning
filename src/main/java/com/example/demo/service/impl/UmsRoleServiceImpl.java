package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.*;
import com.example.demo.mbg.model.*;
import com.example.demo.dao.UmsRoleDao;
import com.example.demo.service.UmsRoleService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;


@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private UmsRoleDao umsRoleDao;
    @Autowired
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
    @Autowired
    private UmsRoleResourceRelationMapper roleResourceRelationMapper;

    //创建角色
    @Override
    public int create(UmsRole umsRole) {
        umsRole.setCreateTime(new Date());  //自增主键？规则呢
        umsRole.setAdminCount(0);
        umsRole.setSort(0);
        return roleMapper.insert(umsRole);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(List<Long> ids) {
        return roleMapper.delete(c->c.where(UmsRoleDynamicSqlSupport.id,isIn(ids)));
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsRole> roleList = new ArrayList<>();
        if (!StringUtils.isEmpty(keyword)){
            roleList = roleMapper.select(c ->c.where(UmsRoleDynamicSqlSupport.name, isLike("%"+keyword+"%")));
            return roleList;
        }
        return null;
    }

    @Override
    public List<UmsRole> list() {
        return roleMapper.select(SelectDSLCompleter.allRows());
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId){
        return  umsRoleDao.getMenuList(adminId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        int count = roleMenuRelationMapper.delete(c -> c.where(UmsRoleMenuRelationDynamicSqlSupport.roleId,isEqualTo(roleId)));
        if (count > 0){
            for (Long menuId: menuIds){
                UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
                relation.setRoleId(roleId);
                relation.setMenuId(menuId);
                roleMenuRelationMapper.insert(relation);
            }
            return menuIds.size();
        }
        return 0;
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return umsRoleDao.getMenuListByRoleId(roleId);
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        int count =  roleResourceRelationMapper.delete(c -> c.where(UmsRoleResourceRelationDynamicSqlSupport.roleId, isEqualTo(roleId)));
        if (count > 0){
            for (Long resourceId: resourceIds){
                UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
                relation.setRoleId(roleId);
                relation.setResourceId(resourceId);
                roleResourceRelationMapper.insert(relation);
            }
            return resourceIds.size();
        }
        return 0;
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return umsRoleDao.getResourceListByRoleId(roleId);
    }
}
