package com.example.steel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/authFailed")
public class AuthFilterController {

    private static final String EXPIRE = "{\n    \"msg\": \"登录认证超时，请重新登录\",\n    \"code\": -110\n}";
    private static final String NO_LOGIN = "{\n    \"msg\": \"用户未登录，请先登录\",\n    \"code\": -110\n}";

    @ResponseBody
    @RequestMapping(value = "/expire", produces = "application/json;charset=UTF-8")
    public String expire() {
        return EXPIRE;
    }

    @ResponseBody
    @RequestMapping(value = "/null", produces = "application/json;charset=UTF-8")
    public String noLogin() {
        return NO_LOGIN;
    }
}
