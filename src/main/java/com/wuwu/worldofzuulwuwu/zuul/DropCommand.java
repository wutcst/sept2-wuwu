package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class DropCommand extends Command{

  @Autowired
  private PlayerService playerService;
  @Autowired
  private PlayerItemService playerItemService;
  @Autowired
  private RoomItemService roomItemService;

  @Override
  public String execute(Long playerId) {

    if(!hasSecondWord()){
      return "drop what?";
    }

    Integer roomId = playerService.getCurrentRoom(playerId);
    Room currentRoom = RoomSetting.rooms.get(RoomSetting.roomIds.get(roomId));
    String itemName = getSecondWord();

    Item item = ItemSetting.getItem(ItemSetting.getId(itemName));
    if(item==null){
      return "You don't own this item.";
    }else{
      playerItemService.removeItem(playerId, itemName);
      roomItemService.addItem(playerId, currentRoom.getName(), itemName);
      return "You dropped " + itemName;
    }

  }
}
