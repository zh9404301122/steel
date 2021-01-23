package com.example.steel.service;

import com.example.steel.vo.LoginVo;

import java.util.List;

/**
 * @author:zh
 * @date:Created in 13:23 2020/3/11
 * @desc
 */
public interface LoginService {

    //查询用户信息;
    List<LoginVo> queryLoginVo(String userName);
}
