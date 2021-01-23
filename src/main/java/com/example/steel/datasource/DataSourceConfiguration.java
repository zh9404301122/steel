package com.example.steel.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@EnableTransactionManagement
@Configuration
@MapperScan(basePackages="com.example.steel.mapper")
public class DataSourceConfiguration {

    @Bean(name = "bizMysql")
    @ConfigurationProperties(prefix = "spring.datasource.druid.biz-mysql")
    public DataSource localMysql() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("multiDataSource")
    @Primary
    public DataSource multiDataSource(@Qualifier("bizMysql") DataSource bizMysql) {
        MultiDataSource multiDataSource = new MultiDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.BIZ_MYSQL, bizMysql);
        multiDataSource.setTargetDataSources(dataSourceMap);
        multiDataSource.setDefaultTargetDataSource(bizMysql);
        return multiDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("multiDataSource") DataSource multiDataSource) throws IOException {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multiDataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*Mapper.xml"));
        SqlSessionFactory bean = null;
        try {
            bean = sqlSessionFactory.getObject();
            log.info(">>>数据源注册成功");
        } catch (Exception e) {
            log.error(">>>数据源注册异常", e);
        }
        return bean;
    }




}
