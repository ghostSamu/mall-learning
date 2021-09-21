package com.example.demo.dto;

import com.example.demo.mbg.model.UmsAdmin;
import com.example.demo.mbg.model.UmsPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AdminUserDetails implements UserDetails {

    private UmsAdmin umsAdmin;
    private List<UmsPermission> umsPermissionList;

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> umsPermissionList){
        this.umsAdmin = umsAdmin;
        this.umsPermissionList = umsPermissionList;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return umsPermissionList.stream().filter(umsPermission -> umsPermission.getValue()!=null)
                .map(umsPermission -> new SimpleGrantedAuthority(umsPermission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword(); //这里不能设置 return null  不然每次都返回空
    }

    @Override
    public String getUsername() {

        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        return umsAdmin.getStatus().equals(1);
    }
}
