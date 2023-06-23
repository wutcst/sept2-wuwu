package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemsCommand extends Command{

  private static PlayerItemService playerItemService;

  @Autowired
  public void setPlayerItemService (PlayerItemService playerItemService){
    ItemsCommand.playerItemService = playerItemService;
  }

  @Override
  public String execute(Long playerId) {
    return playerItemService.getItemsDescription(playerId);
  }
}
