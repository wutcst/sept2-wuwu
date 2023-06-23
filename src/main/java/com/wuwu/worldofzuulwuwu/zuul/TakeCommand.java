package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TakeCommand extends Command{



  private static PlayerItemService playerItemService;

  private  static RoomItemService roomItemService;

  private static PlayerService playerService;

  @Autowired
  public void setRoomItemService (RoomItemService roomItemService){
    TakeCommand.roomItemService = roomItemService;
  }

  @Autowired
  public void setPlayerService (PlayerService playerService){
    TakeCommand.playerService = playerService;
  }

  @Autowired
  public void setPlayerItemService (PlayerItemService playerItemService){
    TakeCommand.playerItemService = playerItemService;
  }

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
      //TODO 考虑拿不起来的情况
      playerItemService.addItem(playerId, itemName);
      roomItemService.removeItem(playerId, currentRoom.getName(), itemName);
      return "You took " + itemName;
    }
  }
}
