package com.example.steel.controller;

import com.example.steel.service.LoginService;
import com.example.steel.util.ResponseBox;
import com.example.steel.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class loginController {


    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;;charset=utf-8")
    @ResponseBody
    public ResponseBox login(HttpServletRequest request, @RequestBody LoginVo loginVo) {
        ResponseBox responseBox = new ResponseBox();
        //-----参数校验：
        if (StringUtils.isEmpty(loginVo.getUserName())) {
            responseBox.setMsg("用户名不能为空");
            responseBox.setSuccess(false);
            return responseBox;
        }
        if (StringUtils.isEmpty(loginVo.getPassword())) {
            responseBox.setMsg("密码不能为空");
            responseBox.setSuccess(false);
            return responseBox;
        }
        List<LoginVo> userList = loginService.queryLoginVo(loginVo.getUserName());
        if (userList == null) {
            responseBox.setMsg("用户名或密码错误");
            responseBox.setSuccess(false);
            return responseBox;
        }
        if (userList.size() > 1) {
            responseBox.setMsg("用户信息重复");
            responseBox.setSuccess(false);
            return responseBox;
        }
        if (!(userList.get(0).getPassword()).equals(loginVo.getPassword())) {
            responseBox.setMsg("用户名或密码错误");
            responseBox.setSuccess(false);
            return responseBox;
        }
        responseBox.setMsg("登陆成功");
        responseBox.setSuccess(true);
        return responseBox;
    }

}
