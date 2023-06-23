package com.wuwu.worldofzuulwuwu.service;

import com.wuwu.worldofzuulwuwu.entity.Player;

public interface PlayerService {
  Boolean register(Player player);
  Long login(Player player);
  Integer getCurrentRoom(Long id);
  Boolean setCurrentRoom(Long id, Integer roomId);

}
