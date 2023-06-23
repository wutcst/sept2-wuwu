package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceImpl implements com.wuwu.worldofzuulwuwu.service.PlayerService {

  @Autowired
  private PlayerDao playerDao;
  @Autowired
  private RoomItemService roomItemService;

  public Boolean register(Player player){
    Player player0 = playerDao.findByName(player.getName());
    if(player0!=null){
      return false;
    }
    int result = playerDao.save(player);
    roomItemService.addItem(player.getId(),"cave", "gem");
    roomItemService.addItem(player.getId(),"cookie_room", "cookie1");
    roomItemService.addItem(player.getId(),"treasure_room", "gold cup");
    roomItemService.addItem(player.getId(),"lobby", "lantern");
    roomItemService.addItem(player.getId(),"weapon_room", "sword");
    roomItemService.addItem(player.getId(),"jail", "cookie2");
    roomItemService.addItem(player.getId(),"jail", "crown");
    roomItemService.addItem(player.getId(),"reading_room", "rune");
    roomItemService.addItem(player.getId(),"exit6", "ring");
    return  result> 0;
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
