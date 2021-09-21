package com.example.demo.component;

import com.example.demo.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import springfox.documentation.spi.service.contexts.SecurityContext;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Jwt登陆授权过滤器
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //获取请求头
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(this.tokenHead)){
            //The part after "Bearer
            String authToken = authHeader.substring(this.tokenHead.length()+1);//substring 截取的范围要+1 因为barer后面还有一个空格
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            LOGGER.info("checking in username:{}",username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                //使用username生成usertails实例
                UserDetails details = this.userDetailsService.loadUserByUsername(username);
                //如果jwt有效
                if (jwtTokenUtil.validateToken(authToken,details)){
                    //
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    LOGGER.info("authentication user:{}",authentication);
                    SecurityContextHolder.getContext().setAuthentication(authentication);//把authentication赋值到context中
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
