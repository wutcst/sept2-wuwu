package com.wuwu.worldofzuulwuwu.service;

import com.wuwu.worldofzuulwuwu.entity.Player;

public interface PlayerService {
  Boolean register(Player player);
  Boolean login(Player player);

}
