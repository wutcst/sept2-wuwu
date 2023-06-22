package com.wuwu.worldofzuulwuwu.service;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.mapper.RoomItemDao;
import zuul.ItemSetting;
import zuul.Room;

public class RoomItemService {
  private RoomItemDao roomItemDao;

  public Boolean addItem(Long playerId, String item){

    RoomItem roomItem = new RoomItem();
    roomItem.setPlayerId(playerId);
    roomItem.setCount(1);

    return roomItemDao.save(roomItem) > 0;
  }

  public Boolean removeItem(Long playerId, Room room, String itemName){

    Integer itemId = ItemSetting.getId(itemName);

    RoomItem roomItem = new RoomItem();
    roomItem.setPlayerId(playerId);
    roomItem.setRoomId(room);

    int result = roomItemDao.delete(roomItem);

    return result > 0;
  }
}
