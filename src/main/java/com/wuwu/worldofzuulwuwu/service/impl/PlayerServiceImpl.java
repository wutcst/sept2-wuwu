package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceImpl implements com.wuwu.worldofzuulwuwu.service.PlayerService {

  @Autowired
  private PlayerDao playerDao;

  public Boolean register(Player player){
    Player player1 = playerDao.save(player);
    if(player1!=null){
      return true;
    }else{
      return false;
    }
  }

  public Long login(Player player){
    Player player1 = playerDao.findByName(player.getName());
    if(player1.getPassword().equals(player.getPassword())){
      return player.getId();
    }else{
      return null;
    }
  }

  public Integer getCurrentRoom(Long id){
    Player player = playerDao.findById(id);
    return player.getCurrentRoom();
  }

  public Boolean setCurrentRoom(Long id, Integer roomId){
    Player player = playerDao.findById(id);
    player.setCurrentRoom(roomId);
    return playerDao.update(player) > 0;
  }


  @Override
  public String getName(Long id) {
    Player player = playerDao.findById(id);
    return player.getName();
  }
}
