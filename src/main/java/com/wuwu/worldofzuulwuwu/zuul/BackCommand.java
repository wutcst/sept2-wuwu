package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.common.Record;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:wangyuze
 * @create: 2023-06-23 15:53
 * @Description: 回退指令
 */

public class BackCommand extends Command {
    @Autowired
    private PlayerService playerService;

    public String execute(Long playerId){
        if(hasSecondWord()){
            if(getSecondWord().equals("over")){
                Integer currentRoomInt = playerService.getCurrentRoom(playerId);
                RoomId roomId = RoomSetting.roomIds.get(currentRoomInt);
                Record.record(playerId,roomId);
                playerService.setCurrentRoom(playerId,RoomId.ENTRANCE.getId());
                Room entrance = RoomSetting.rooms.get(RoomId.ENTRANCE);
                return entrance.getLongDescription();
            }
        }
        else{
            RoomId roomId = Record.back(playerId);
            Boolean ok = playerService.setCurrentRoom(playerId, roomId.getId());
            if(ok){
                Room nextRoom=RoomSetting.rooms.get(roomId);
                return nextRoom.getLongDescription();
            }
        }
        return null;
    }
}
