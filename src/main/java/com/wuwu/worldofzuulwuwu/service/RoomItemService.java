package com.wuwu.worldofzuulwuwu.service;

import zuul.Room;

public interface RoomItemService {
  Boolean addItem(Long playerId, String item);
  Boolean removeItem(Long playerId, Room room, String itemName);
  String lookUpAllItems(Long playerId, Room room);

}
