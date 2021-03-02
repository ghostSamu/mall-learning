package com.example.demo.service;

import com.example.demo.common.api.CommonResult;

/**
* @Description:会员管理
*/
public interface UmsMemberService {

    //注册
    void register(String username, String password, String telephone, String authCode);

    //生成验证码
    CommonResult getAuthCode(String telephone);

    //判断验证码和手机号是否匹配
    CommonResult verifyAuthCode(String telephone, String authCode);
}
