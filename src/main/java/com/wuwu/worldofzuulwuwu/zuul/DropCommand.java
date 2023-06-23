package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class DropCommand extends Command{

  private static PlayerItemService playerItemService;

  private  static RoomItemService roomItemService;

  private static PlayerService playerService;

  @Autowired
  public void setRoomItemService (RoomItemService roomItemService){
    DropCommand.roomItemService = roomItemService;
  }

  @Autowired
  public void setPlayerService (PlayerService playerService){
    DropCommand.playerService = playerService;
  }

  @Autowired
  public void setPlayerItemService (PlayerItemService playerItemService){
    DropCommand.playerItemService = playerItemService;
  }

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
