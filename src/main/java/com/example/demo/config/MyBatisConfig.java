package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.example.demo.mbg.mapper","com.example.demo.dao"})
public class MyBatisConfig {
}
