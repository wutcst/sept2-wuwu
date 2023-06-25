package com.wuwu.worldofzuulwuwu.controller;

import com.wuwu.worldofzuulwuwu.common.Result;
import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

<<<<<<< HEAD
=======
/**
 * Controller class for user registration.
 */
>>>>>>> 656701185ab67113279f3127cbb7c3aa729f458b
@Controller
@RequestMapping("/register")
@ResponseBody
public class RegisterController {

    @Autowired
    private PlayerService playerService;

    /**
     * Handles user registration request.
     *
     * @param data The map of request parameters.
     * @return The Result object containing the registration result.
     */
    @PostMapping
    public Result register(@RequestBody Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");
        if (username == null || password == null) {
            return new Result(0, "error", "Registration failed. Invalid username or password.");
        }
        Player player = new Player();
        long id = IdWorker.getId();
        player.setId(id);
        player.setName(username);
        player.setPassword(password);
        player.setCurrentRoom(0);
        player.setCapacity(10);
        Boolean success = playerService.register(player);
        if (success) {
            return new Result(1, "success", "Successfully registered.");
        } else {
            return new Result(0, "error", "Registration failed. Username already exists.");
        }
    }
}
