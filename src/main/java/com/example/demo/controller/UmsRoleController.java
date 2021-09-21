package com.example.demo.controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.mbg.mapper.UmsRoleMapper;
import com.example.demo.mbg.model.UmsRole;
import com.example.demo.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsRole role){
        int count = umsRoleService.create(role);
        if (count > 0){
            CommonResult.success(count);
        }
        return CommonResult.failed();
    }




    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> listAll(){
        List<UmsRole> umsRoleList = umsRoleService.list();
        return CommonResult.success(umsRoleList);
    }
}
