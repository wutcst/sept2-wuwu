package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LookCommand extends Command{


  private  static RoomItemService roomItemService;

  private static PlayerService playerService;

  @Autowired
  public void setRoomItemService (RoomItemService roomItemService){
    LookCommand.roomItemService = roomItemService;
  }

  @Autowired
  public void setPlayerService (PlayerService playerService){
    LookCommand.playerService = playerService;
  }
  @Override
  public String execute(Long playerId) {

    Integer currentRoomId = playerService.getCurrentRoom(playerId);
    Room currentRoom = RoomSetting.rooms.get(RoomSetting.roomIds.get(currentRoomId));

    List<RoomItem> roomItemList = roomItemService.lookUpAllItems(playerId, currentRoom.getName());
    if(roomItemList.isEmpty()){
      return "You find nothing in this room";
    }
    StringBuilder msg = new StringBuilder("You find:\n");
    for(RoomItem roomItem : roomItemList){
      Integer itemId = roomItem.getId();
      Item item = ItemSetting.getItem(itemId);
      msg.append("[").append(item.getName()).append("] [").append(item.getDescription())
          .append("] [").append(item.getWeight()).append("]\n");
    }
    return msg.toString();
  }

}
