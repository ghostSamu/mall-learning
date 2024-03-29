package com.example.demo.aspect;

import com.example.demo.annotation.CacheException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(2)
public class RedisCacheAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(RedisCacheAspect.class);

    //设置切入的类和类中方法的范围
    @Pointcut("execution(public * com.example.demo.service.*CacheService.*(..))")
    public void cacheAspect(){

    }

    @Around("cacheAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object result = null;
        try {
            result = joinPoint.proceed();
        }catch (Throwable throwable){
            if (method.isAnnotationPresent(CacheException.class)){
                throw throwable;
            }else {
                LOGGER.error(throwable.getMessage());
            }
        }
        return result;
    }
}
