package com.example.demo.service;


import com.example.demo.mbg.model.UmsAdmin;

public interface UmsAdminService {

    //注册
    UmsAdmin register(UmsAdmin umsAdminParam);
    //登陆
    String login(String username, String password);
}
