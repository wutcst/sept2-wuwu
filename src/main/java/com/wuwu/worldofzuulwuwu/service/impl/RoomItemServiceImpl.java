package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.mapper.RoomItemDao;
import java.util.List;

import com.wuwu.worldofzuulwuwu.zuul.ItemSetting;
import com.wuwu.worldofzuulwuwu.zuul.RoomId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomItemServiceImpl implements com.wuwu.worldofzuulwuwu.service.RoomItemService {
  @Autowired
  private RoomItemDao roomItemDao;

  @Override
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

  @Override
  public Boolean addItem(Long playerId, String roomName, String itemName){

    Integer itemId = ItemSetting.getId(itemName);
    Integer roomId = RoomId.getRoomId(roomName);

    RoomItem roomItem = new RoomItem();
    roomItem.setPlayerId(playerId);
    roomItem.setRoomId(roomId);
    roomItem.setId(itemId);

    return roomItemDao.save(roomItem) > 0;
  }

  @Override
  public List<RoomItem> lookUpAllItems(Long playerId, String roomName) {
    return roomItemDao.findAll(playerId, RoomId.getRoomId(roomName));
  }
}
