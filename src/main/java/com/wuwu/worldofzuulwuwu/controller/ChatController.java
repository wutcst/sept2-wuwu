package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import com.wuwu.worldofzuulwuwu.zuul.Command;
import com.wuwu.worldofzuulwuwu.zuul.Parser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller class for processing chat data.
 */
@Controller
@RequestMapping("/main")
@ResponseBody
@CrossOrigin(origins = {"http://localhost:7000"})
public class ChatController {

    @Autowired
    private Parser parser;

    /**
     * Processes the chat message and returns the result.
     *
     * @param data         The map of request parameters.
     * @param httpSession  The HttpSession object.
     * @return The Result object containing the processing result.
     */
    @PostMapping
    public Result processMessage(@RequestBody Map<String, String> data, HttpSession httpSession) {
        String command = data.get("command");
        Command parserCommand = parser.getCommand(command);
        Long playerId = (Long) httpSession.getAttribute("playerId");
        String response = parserCommand.execute(playerId);
        if (response == null) {
            return new Result(1, "success", "I'm sorry, I do not understand.");
        } else {
            return new Result(1, "success", response);
        }
    }
}
