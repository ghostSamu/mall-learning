package com.example.demo.controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.mbg.mapper.UmsRoleMapper;
import com.example.demo.mbg.model.UmsRole;
import com.example.demo.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> listAll(){
        List<UmsRole> umsRoleList = umsRoleService.list();
        return CommonResult.success(umsRoleList);
    }
}
