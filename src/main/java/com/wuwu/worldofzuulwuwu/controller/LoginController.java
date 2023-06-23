package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author:wangyuze
 * @create: 2023-06-23 13:52
 * @Description: 用户登录
 */
@Controller
@RequestMapping("./login")
public class LoginController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public Result login(Map<String,String> data){
        String username = data.get("username");
        String password = data.get("password");
        Player player=new Player();
        player.setName(username);
        player.setPassword(password);
        Boolean ok = playerService.login(player);
        return new Result(ok?1:0,"","");
    }
}
