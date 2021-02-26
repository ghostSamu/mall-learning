package com.example.demo.controller;

import com.example.demo.common.api.CommonResult;
import com.example.demo.mbg.model.PmsBrand;
import com.example.demo.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Api(tags = "PmsBrandController",description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        System.out.println("接收到请求");
        return CommonResult.success(brandService.listAll());
    }
}
