package com.wuwu.worldofzuulwuwu.service;

import org.springframework.stereotype.Service;

public interface PlayerItemService {
  Boolean addItem(Long playerId, String item);
  Boolean removeItem(Long playerId, String itemName);

}
