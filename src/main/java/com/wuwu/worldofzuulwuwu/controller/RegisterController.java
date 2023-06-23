package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author:wangyuze
 * @create: 2023-06-23 13:23
 * @Description: 用户注册
 */
@Controller
public class RegisterController {

//    @Autowired
//    private Pl

//    @PostMapping("/login")
    public Result register(Map<String,String> data){
        String username = data.get("username");
        String password = data.get("password");


    }
}
