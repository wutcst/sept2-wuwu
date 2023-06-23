package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.mapper.RoomItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import com.wuwu.worldofzuulwuwu.zuul.ItemSetting;
import com.wuwu.worldofzuulwuwu.zuul.Room;
import com.wuwu.worldofzuulwuwu.zuul.RoomId;

public class RoomItemServiceImpl implements com.wuwu.worldofzuulwuwu.service.RoomItemService {
  @Autowired
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
    roomItem.setRoomId(RoomId.getRoomId(room.getName()));
    roomItem.setId(ItemSetting.getId(itemName));
    int result = roomItemDao.delete(roomItem);

    return result > 0;
  }
}
