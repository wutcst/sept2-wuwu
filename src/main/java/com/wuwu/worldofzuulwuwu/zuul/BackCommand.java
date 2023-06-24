package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.common.Record;
import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The BackCommand class represents a command to go back to the previous room in the game.
 * It is a component managed by Spring and is used in the game's Zuul framework.
 *
 * @author: wangyuze
 * @create: 2023-06-23 15:53
 * @Description: Command for going back to the previous room
 */
@Component
public class BackCommand extends Command {

    private static PlayerService playerService;

    /**
     * Sets the player service using Spring's dependency injection.
     *
     * @param playerService the player service to be set
     */
    @Autowired
    public void setPlayerService(PlayerService playerService) {
        BackCommand.playerService = playerService;
    }

    /**
     * Executes the back command for the specified player.
     *
     * @param playerId the ID of the player executing the command
     * @return the description of the next room or null if the command is invalid
     */
    public String execute(Long playerId) {
        if (hasSecondWord()) {
            if (getSecondWord().equals("over")) {
                // Save the current room and go back to the entrance
                Integer currentRoomInt = playerService.getCurrentRoom(playerId);
                RoomId roomId = RoomSetting.roomIds.get(currentRoomInt);
                Record.record(playerId, roomId);
                playerService.setCurrentRoom(playerId, RoomId.ENTRANCE.getId());
                Room entrance = RoomSetting.rooms.get(RoomId.ENTRANCE);
                return entrance.getLongDescription();
            }
        } else {
            // Go back to the previous room
            RoomId roomId = Record.back(playerId);
            Boolean ok = playerService.setCurrentRoom(playerId, roomId.getId());
            if (ok) {
                Room nextRoom = RoomSetting.rooms.get(roomId);
                return nextRoom.getLongDescription();
            }
        }
        return null;
    }
}
