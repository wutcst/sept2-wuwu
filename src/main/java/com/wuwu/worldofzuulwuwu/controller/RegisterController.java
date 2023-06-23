package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/register")
@ResponseBody
public class RegisterController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public Result register(@RequestParam Map<String,String> data){
        String username = data.get("username");
        String password = data.get("password");
        if(username==null || password==null){
            return new Result(0,"error","error register");
        }
        Player player=new Player();
        long id = IdWorker.getId();
        player.setId(id);
        player.setName(username);
        player.setPassword(password);
        player.setCurrentRoom(0);
        player.setCapacity(10);
        Boolean ok = playerService.register(player);
        if(ok){
            return new Result(1,"success","success register");
        }
        else{
            return new Result(0,"error","error register");
        }
    }
}
