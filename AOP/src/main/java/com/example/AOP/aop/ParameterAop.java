package com.example.AOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.AOP.controller..*.*(..))")
    private void cut(){

    }

    @Before("cut")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for(Object item:args){
            System.out.println("type : "+item.getClass().getSimpleName());
            System.out.println("value : "+item);
        }
    }

    @AfterReturning(value = "cut", returning = "obj")
    public void afterReturn(JoinPoint joinPoint, Object obj){
        System.out.println("return object");
        System.out.println(obj);
    }
}
