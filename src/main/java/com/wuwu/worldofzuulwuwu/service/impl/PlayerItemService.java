package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.mapper.PlayerItemDao;
import java.util.List;
import zuul.ItemSetting;
import zuul.Room;
import zuul.RoomId;

public class PlayerItemService implements com.wuwu.worldofzuulwuwu.service.PlayerItemService {

  private PlayerItemDao playerItemDao;

  public Boolean addItem(Long playerId, String item){

    PlayerItem playerItem = new PlayerItem();
    playerItem.setPlayerId(playerId);
    playerItem.setCount(1);

    PlayerItem playerItem1 = playerItemDao.save(playerItem);

    return playerItem1 != null;
  }

  public Boolean removeItem(Long playerId, String itemName){

  Integer itemId = ItemSetting.getId(itemName);

    PlayerItem playerItem = new PlayerItem();
    playerItem.setPlayerId(playerId);
    playerItem.setId(itemId);

    int result = playerItemDao.delete(playerItem);

    return result > 0;
  }

  @Override
  public List<PlayerItem> lookUpAllItems(Long playerId) {
    List<RoomItem> itemList = playerItemDao.findAll();
    return itemList;
  }
}
