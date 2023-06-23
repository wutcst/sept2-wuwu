package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.mapper.PlayerItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import com.wuwu.worldofzuulwuwu.zuul.ItemSetting;
import org.springframework.stereotype.Service;

@Service
public class PlayerItemServiceImpl implements com.wuwu.worldofzuulwuwu.service.PlayerItemService {

  @Autowired
  private PlayerItemDao playerItemDao;

  public Boolean addItem(Long playerId, String itemName){

    PlayerItem playerItem = new PlayerItem();
    playerItem.setPlayerId(playerId);
    playerItem.setId(ItemSetting.getId(itemName));
    playerItem.setCount(1);

    int playerItem1 = playerItemDao.save(playerItem);

    return playerItem1 > 0;
  }

  public Boolean removeItem(Long playerId, String itemName){

  Integer itemId = ItemSetting.getId(itemName);

    PlayerItem playerItem = new PlayerItem();
    playerItem.setPlayerId(playerId);
    playerItem.setId(itemId);

    return playerItemDao.delete(playerItem) > 0;
  }
}
