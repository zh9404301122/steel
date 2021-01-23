package com.example.steel.config;


import com.example.steel.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;


/*@Configuration*/
public class FilterRegistrationConfig {

    private static final String AUTHOR_KEY = "author";
    private static final String AUTHOR_VAL = "zhanghui";


    @Bean(name = "authFilterRegistration")
    @Autowired
    public FilterRegistrationBean authFilterRegistration(Filter authFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(authFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter(AUTHOR_KEY, AUTHOR_VAL);
        registration.setName("authFilter");
        registration.setOrder(1);
        return registration;
    }


    @Bean(name = "authFilter")
    public Filter authFilter() {
        return new AuthFilter();
    }

}
