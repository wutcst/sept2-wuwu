package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("playerService")
@Slf4j
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  private PlayerDao playerDao;
  @Autowired
  private RoomItemService roomItemService;

  @Override
  public Boolean register(Player player){
    Player player0 = playerDao.findByName(player.getName());
    log.info("player= ",player0);
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

  @Override
  public Long login(Player player){
    Player player1 = playerDao.findByName(player.getName());
    log.info(player.toString());
    log.info(player1.toString());
    if(player1.getPassword().equals(player.getPassword())){
      return player1.getId();
    }else{
      return null;
    }
  }

  @Override
  public Integer getCurrentRoom(Long id){
    Player player = playerDao.findById(id);
    return player.getCurrentRoom();
  }

  @Override
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

  @Override
  public Integer getCapacity(Long id) {
    Player player = playerDao.findById(id);
    return player.getCapacity();
  }

  @Override
  public void addCapacity(Long id, Integer increment) {
    Player player = playerDao.findById(id);
    player.setCapacity(player.getCapacity() + increment);
  }
}
