package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

<<<<<<< HEAD
=======
/**
 * Controller class for user login.
 */
>>>>>>> 656701185ab67113279f3127cbb7c3aa729f458b
@Controller
@RequestMapping("/login")
@ResponseBody
@Slf4j
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
    public Result login(@RequestBody Map<String, String> data, HttpSession httpSession) {
        String username = data.get("username");
        String password = data.get("password");
        Player player = new Player();
        player.setName(username);
        player.setPassword(password);
        Long playerId = playerService.login(player);
        if (playerId != null) {
            httpSession.setAttribute("playerId", playerId);
            log.info(httpSession.getId());
            Integer sessionTimeout = httpSession.getServletContext().getSessionTimeout();
            log.info("time= ",sessionTimeout);
            return new Result(1, "success", "Successfully logged in.");
        } else {
            return new Result(0, "error", "Login failed. Invalid username or password.");
        }
    }
}
