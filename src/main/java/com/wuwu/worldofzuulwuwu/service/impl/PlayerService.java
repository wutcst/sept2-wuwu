package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;

public class PlayerService implements com.wuwu.worldofzuulwuwu.service.PlayerService {

  private PlayerDao playerDao;

  public Boolean register(Player player){
    Player player1 = playerDao.save(player);
    if(player1!=null){
      return true;
    }else{
      return false;
    }
  }

  public Boolean login(Player player){
    Player player1 = playerDao.findByName(player.getName());
    if(player1.getPassword().equals(player.getPassword())){
      return true;
    }else{
      return false;
    }
  }

}
