package com.wuwu.worldofzuulwuwu.service;

public interface PlayerItemService {
  Boolean addItem(Long playerId, String item);
  Boolean removeItem(Long playerId, String itemName);

}
