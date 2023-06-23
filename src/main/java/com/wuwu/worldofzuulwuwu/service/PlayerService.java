package com.wuwu.worldofzuulwuwu.service;

import com.wuwu.worldofzuulwuwu.entity.Player;
import org.springframework.stereotype.Service;

@Service("playerService")
public interface PlayerService {
  Boolean register(Player player);
  Long login(Player player);
  Integer getCurrentRoom(Long id);
  Boolean setCurrentRoom(Long id, Integer roomId);

  String getName(Long id);

}
