package com.example.steel.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 */
@Aspect
@Component
public class DataSourceAspect {

    @Before("execution(* com.example.steel.mapper.*.*(..))")
    public void setDataSourceLocal(JoinPoint point){
        DataSourceContextHolder.setDataSource(DataSourceEnum.BIZ_MYSQL);
    }
    @After("execution(* com.example.steel.mapper.*.*(..))")
    public void clearDataSourceLocal(JoinPoint point){
        DataSourceContextHolder.clear();
    }

}
