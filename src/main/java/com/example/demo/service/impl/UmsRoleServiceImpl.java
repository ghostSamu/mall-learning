package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.UmsRoleMapper;
import com.example.demo.mbg.model.UmsMenu;
import com.example.demo.mbg.model.UmsRole;
import com.example.demo.dao.UmsRoleDao;
import com.example.demo.service.UmsRoleService;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private UmsRoleDao umsRoleDao;

    //创建角色
    @Override
    public int create(UmsRole umsRole) {
        umsRole.setCreateTime(new Date());
        umsRole.setAdminCount(0);
        umsRole.setSort(0);
        return roleMapper.insert(umsRole);
    }

    @Override
    public List<UmsRole> list() {
        return roleMapper.select(SelectDSLCompleter.allRows());
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId){
        return  umsRoleDao.getMenuList(adminId);
    }
}
