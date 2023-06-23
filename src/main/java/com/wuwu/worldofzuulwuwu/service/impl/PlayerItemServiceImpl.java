package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.mapper.PlayerItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import com.wuwu.worldofzuulwuwu.zuul.ItemSetting;
import org.springframework.stereotype.Service;

@Service
public class PlayerItemServiceImpl implements com.wuwu.worldofzuulwuwu.service.PlayerItemService {

  @Autowired
  private PlayerItemDao playerItemDao;

  @Autowired
  private PlayerDao playerDao;

  public Boolean addItem(Long playerId, String itemName){

    Player player = playerDao.findById(playerId);
    Integer capacity = player.getCapacity();

    Integer itemWeight = ItemSetting.getItem(ItemSetting.getId(itemName)).getWeight();

    capacity -= itemWeight;

    playerDao.save(player);

    PlayerItem playerItem = new PlayerItem();
    playerItem.setPlayerId(playerId);
    playerItem.setId(ItemSetting.getId(itemName));
    playerItem.setCount(1);

    int playerItem1 = playerItemDao.save(playerItem);

    return playerItem1 > 0;
  }

  public Boolean removeItem(Long playerId, String itemName){

    Player player = playerDao.findById(playerId);
    Integer capacity = player.getCapacity();

    Integer itemWeight = ItemSetting.getItem(ItemSetting.getId(itemName)).getWeight();

    capacity += itemWeight;

    playerDao.save(player);



    Integer itemId = ItemSetting.getId(itemName);

    PlayerItem playerItem = new PlayerItem();
    playerItem.setPlayerId(playerId);
    playerItem.setId(itemId);

    return playerItemDao.delete(playerItem) > 0;
  }
}
