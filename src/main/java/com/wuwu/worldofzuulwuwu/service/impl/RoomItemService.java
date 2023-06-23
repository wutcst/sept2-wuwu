package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.mapper.RoomItemDao;
import java.util.List;
import zuul.ItemSetting;
import zuul.Room;
import zuul.RoomId;
import zuul.RoomSetting;

public class RoomItemService implements com.wuwu.worldofzuulwuwu.service.RoomItemService {
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

  @Override
  public List<RoomItem> lookUpAllItems(Long playerId, Room room) {
    List<RoomItem> itemList = roomItemDao.findAll(playerId, RoomId.getRoomId(room.getName()));
    return itemList;
  }
}
