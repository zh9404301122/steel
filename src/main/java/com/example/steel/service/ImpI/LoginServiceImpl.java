package com.example.steel.service.ImpI;

import com.example.steel.mapper.LoginMapper;
import com.example.steel.service.LoginService;
import com.example.steel.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:zh
 * @date:Created in 13:24 2020/3/11
 * @desc
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<LoginVo> queryLoginVo(String userName) {
        return loginMapper.queryLoginVo(userName);
    }
}
