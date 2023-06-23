package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zuul.Command;
import zuul.Parser;

import java.util.Map;

/**
 * @author:wangyuze
 * @create: 2023-06-23 14:11
 * @Description: 聊天数据处理
 */
@Controller
@RequestMapping("./main")
public class ChatController {

    @Autowired
    private Parser parser;

    @PostMapping
    public Result processMessage(Map<String,String> data){
        String command = data.get("command");
        Command parserCommand = parser.getCommand(command);
        parserCommand.execute()
    }
}
