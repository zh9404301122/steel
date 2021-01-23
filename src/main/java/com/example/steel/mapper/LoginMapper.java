package com.example.steel.mapper;

import com.example.steel.vo.LoginVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:zh
 * @date:Created in 18:09 2020/2/29
 * @desc
 */
@Repository
public interface LoginMapper {

    //用户登录查询;
    List<LoginVo> queryLoginVo(String userName);

}
