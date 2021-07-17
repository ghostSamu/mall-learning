package com.example.demo.config;

import com.example.demo.dto.AdminUserDetails;
import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsPermission;
import com.example.demo.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UmsAdminService umsAdminService;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
        httpSecurity.cors().and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //根据UserDetail的username查找用户
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(username);
            if (umsAdmin != null){
                List<UmsPermission> permissionList = umsAdminService.getPermissionList(umsAdmin.getId());
                return new AdminUserDetails(umsAdmin, permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }
}
