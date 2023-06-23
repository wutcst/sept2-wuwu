package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author:wangyuze
 * @create: 2023-06-23 13:52
 * @Description: 用户登录
 */
@Controller
@RequestMapping("/login")
@ResponseBody
public class LoginController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public Result login(@RequestParam Map<String,String> data, HttpSession httpSession){
        String username = data.get("username");
        String password = data.get("password");
        Player player=new Player();
        player.setName(username);
        player.setPassword(password);
        Long id = playerService.login(player);
        if(id!=null){
            httpSession.setAttribute("playerId",id);
            return new Result(1,"success","success login");
        }
        else{
            return new Result(0,"error","error login");
        }
    }
}
