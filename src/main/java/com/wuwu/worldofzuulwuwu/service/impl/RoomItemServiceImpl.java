package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.mapper.RoomItemDao;
import com.wuwu.worldofzuulwuwu.zuul.ItemSetting;
import com.wuwu.worldofzuulwuwu.zuul.RoomId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomItemServiceImpl implements com.wuwu.worldofzuulwuwu.service.RoomItemService {

  @Autowired
  private RoomItemDao roomItemDao;
  @Autowired
  private PlayerDao playerDao;

  /**
   * Removes an item from a player's current room.
   *
   * @param playerId  The ID of the player.
   * @param roomName  The name of the room.
   * @param itemName  The name of the item to remove.
   * @return {@code true} if the item was successfully removed, {@code false} otherwise.
   */
  @Override
  public Boolean removeItem(Long playerId, String roomName, String itemName) {
    Integer itemId = ItemSetting.getId(itemName);
    Integer roomId = RoomId.getRoomId(roomName);

    RoomItem roomItem = new RoomItem();
    roomItem.setPlayerId(playerId);
    roomItem.setRoomId(roomId);
    roomItem.setId(itemId);
    roomItem.setCount(1);

    return roomItemDao.delete(roomItem) > 0;
  }

  /**
   * Adds an item to a player's current room.
   *
   * @param playerId  The ID of the player.
   * @param roomName  The name of the room.
   * @param itemName  The name of the item to add.
   * @return {@code true} if the item was successfully added, {@code false} otherwise.
   */
  @Override
  public Boolean addItem(Long playerId, String roomName, String itemName) {
    Integer itemId = ItemSetting.getId(itemName);
    Integer roomId = RoomId.getRoomId(roomName);

    RoomItem roomItem = new RoomItem();
    roomItem.setPlayerId(playerId);
    roomItem.setRoomId(roomId);
    roomItem.setId(itemId);

    return roomItemDao.save(roomItem) > 0;
  }

  /**
   * Retrieves a list of all items in a player's current room.
   *
   * @param playerId  The ID of the player.
   * @param roomName  The name of the room.
   * @return A list of room items.
   */
  @Override
  public List<RoomItem> lookUpAllItems(Long playerId, String roomName) {
    return roomItemDao.findAll(playerId, RoomId.getRoomId(roomName));
  }
}
