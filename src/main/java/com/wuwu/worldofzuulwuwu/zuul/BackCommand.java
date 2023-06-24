package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.common.Record;
import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BackCommand 类是一个继承自 Command 的类，用于处理“回退”指令。
 */
@Component
public class BackCommand extends Command {

    // PlayerService 用于处理玩家相关信息的服务类。
    private static PlayerService playerService;

    /**
     * 使用 @Autowired 注解告诉 Spring 框架需要注入 PlayerService 实例。
     *
     * @param playerService 玩家服务实例。
     */
    @Autowired
    public void setPlayerService (PlayerService playerService){
        BackCommand.playerService = playerService;
    }

    /**
     * 执行“回退”指令，并返回字符串类型的值。
     *
     * @param playerId 玩家 ID。
     * @return 如果传送成功则返回该房间的长描述信息，否则返回 null。
     */
    public String execute(Long playerId){
        if(hasSecondWord()){
            // 如果存在第二个单词，则判断其是否等于 "over"。
            if(getSecondWord().equals("over")){
                // 记录玩家所在房间，并将其传送到入口房间。
                Integer currentRoomInt = playerService.getCurrentRoom(playerId);
                RoomId roomId = RoomSetting.roomIds.get(currentRoomInt);
                Record.record(playerId,roomId);
                playerService.setCurrentRoom(playerId,RoomId.ENTRANCE.getId());
                Room entrance = RoomSetting.rooms.get(RoomId.ENTRANCE);
                return entrance.getLongDescription();
            }
        }
        else{
            // 获取上一次所在的房间 ID，并将玩家传送到该房间。
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
