package com.wuwu.worldofzuulwuwu.service;

import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import java.util.List;
import zuul.Room;

public interface RoomItemService {
  Boolean addItem(Long playerId, String item);
  Boolean removeItem(Long playerId, Room room, String itemName);
  List<RoomItem> lookUpAllItems(Long playerId, Room room);

}
