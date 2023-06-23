package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.mapper.RoomItemDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import zuul.ItemSetting;
import zuul.Room;
import zuul.RoomId;
import zuul.RoomSetting;

public class RoomItemService implements com.wuwu.worldofzuulwuwu.service.RoomItemService {
  @Autowired
  private RoomItemDao roomItemDao;

  public Boolean removeItem(Long playerId, String roomName, String itemName){

    Integer itemId = ItemSetting.getId(itemName);
    Integer roomId = RoomId.getRoomId(roomName);

    RoomItem roomItem = new RoomItem();
    roomItem.setPlayerId(playerId);
    roomItem.setRoomId(roomId);
    roomItem.setId(itemId);
    roomItem.setCount(1);

    return roomItemDao.delete(roomItem) > 0;
  }

  public Boolean addItem(Long playerId, String roomName, String itemName){

    Integer itemId = ItemSetting.getId(itemName);
    Integer roomId = RoomId.getRoomId(roomName);

    RoomItem roomItem = new RoomItem();
    roomItem.setPlayerId(playerId);
    roomItem.setRoomId(roomId);
    roomItem.setId(itemId);

    return roomItemDao.save(roomItem) > 0;
  }
}
