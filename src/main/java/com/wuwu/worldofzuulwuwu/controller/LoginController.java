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
 * Controller class for user login.
 */
@Controller
@RequestMapping("/login")
@ResponseBody
public class LoginController {

    @Autowired
    private PlayerService playerService;

    /**
     * Handles user login request.
     *
     * @param data        The map of request parameters.
     * @param httpSession The HttpSession object.
     * @return The Result object containing the login result.
     */
    @PostMapping
    public Result login(@RequestParam Map<String, String> data, HttpSession httpSession) {
        String username = data.get("username");
        String password = data.get("password");
        Player player = new Player();
        player.setName(username);
        player.setPassword(password);
        Long playerId = playerService.login(player);
        if (playerId != null) {
            httpSession.setAttribute("playerId", playerId);
            return new Result(1, "success", "Successfully logged in.");
        } else {
            return new Result(0, "error", "Login failed. Invalid username or password.");
        }
    }
}
