package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wuwu.worldofzuulwuwu.zuul.Command;
import com.wuwu.worldofzuulwuwu.zuul.Parser;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/main")
@ResponseBody
public class ChatController {

    @Autowired
    private Parser parser;

    @PostMapping
    public Result processMessage(@RequestParam Map<String,String> data, HttpSession httpSession){
        String command = data.get("command");
        Command parserCommand = parser.getCommand(command);
        Long id = (Long)httpSession.getAttribute("playerId");
        String res = parserCommand.execute(id);
        if(res==null){
            return new Result(1,"success","I am sorry, I do not understand.");
        }
        else{
            return new Result(1,"success",res);
        }
    }
}
