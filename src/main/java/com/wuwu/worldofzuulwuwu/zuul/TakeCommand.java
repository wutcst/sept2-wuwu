package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class TakeCommand extends Command{

  @Autowired
  private PlayerService playerService;
  @Autowired
  private PlayerItemService playerItemService;
  @Autowired
  private RoomItemService roomItemService;

  @Override
  public String execute(Long playerId) {
    //未指明要获取什么物品
    if(!hasSecondWord()){
      return "take what?";
    }

    Integer roomId = playerService.getCurrentRoom(playerId);
    Room currentRoom = RoomSetting.rooms.get(RoomSetting.roomIds.get(roomId));
    String itemName = getSecondWord();

    Item item = ItemSetting.getItem(ItemSetting.getId(itemName));
    if(item==null){
      return "There is no such item.";
    }else{
      playerItemService.addItem(playerId, itemName);
      roomItemService.removeItem(playerId, currentRoom.getName(), itemName);
      return "You took " + itemName;
    }
  }
}
