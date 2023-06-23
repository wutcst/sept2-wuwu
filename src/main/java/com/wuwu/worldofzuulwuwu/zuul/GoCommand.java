package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.common.Record;
import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import com.wuwu.worldofzuulwuwu.service.impl.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoCommand extends Command
{


    private static PlayerService playerService;


    @Autowired
    public void setPlayerService (PlayerService playerService){
        GoCommand.playerService = playerService;
    }



    public String execute(Long playerId)
    {
        if(!hasSecondWord()) {
            return "go where?";
        }

        String direction = getSecondWord();

        RoomId roomId = RoomSetting.roomIds.get(playerService.getCurrentRoom(playerId));
        Room currentRoom = RoomSetting.rooms.get(roomId);

        Room nextRoom = currentRoom.getExit(direction);


        if (nextRoom == null) {
            return "There is no door!";
        }
        else {
            Record.record(playerId,roomId);
            playerService.setCurrentRoom(playerId, RoomId.getRoomId(nextRoom.getName()));
            return nextRoom.getLongDescription();
        }
    }
}
