package com.example.demo.service.impl;

import com.example.demo.dto.UmsMenuNode;
import com.example.demo.mbg.mapper.UmsMenuMapper;
import com.example.demo.mbg.model.UmsMenu;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UmsMenuServiceImpl implements UmsMenuService{

    @Autowired
    private UmsMenuMapper umsMenuMapper;

    @Override
    public List<UmsMenuNode> getTreeList() {
        List<UmsMenu> menuList = umsMenuMapper.select(c->c);
        List<UmsMenuNode> result = menuList.stream().filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    private UmsMenuNode covertMenuNode(UmsMenu umsMenu, List<UmsMenu> menuList){
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(umsMenu, node);
        List<UmsMenuNode> children = menuList.stream().filter(subMenu -> subMenu.getParentId().equals(umsMenu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
