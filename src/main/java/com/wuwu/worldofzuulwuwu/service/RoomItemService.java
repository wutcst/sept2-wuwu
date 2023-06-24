package com.wuwu.worldofzuulwuwu.service;

import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import java.util.List;
import com.wuwu.worldofzuulwuwu.zuul.Room;
import org.springframework.stereotype.Service;


public interface RoomItemService {
  Boolean addItem(Long playerId, String roomName, String itemName);
  Boolean removeItem(Long playerId, String roomName, String itemName);

  List<RoomItem> lookUpAllItems(Long playerId, String roomName);
}
