package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.common.Record;
import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The GoCommand class represents a command to go in a specific direction in the game.
 * It is a component managed by Spring and is used in the game's Zuul framework.
 *
 * The GoCommand allows the player to move from one room to another by specifying a direction.
 * The command checks if there is a valid exit in the specified direction from the current room.
 * If there is, the player's current room is updated, and the description of the new room is returned.
 * If there is no valid exit, a message indicating that there is no door is returned.
 *
 * The GoCommand requires the PlayerService to get and set the current room of the player.
 * The Record class is used to record the player's current room before moving to the next room.
 *
 * Note: The implementation of the getExit() method in the Room class is required for this command to work properly.
 *
 * @author:wangyuze
 * @create: 2023-06-23 15:53
 * @Description: Command for going in a specific direction
 */
@Component
public class GoCommand extends Command {

    private static PlayerService playerService;

    /**
     * Sets the player service using Spring's dependency injection.
     *
     * @param playerService the player service to be set
     */
    @Autowired
    public void setPlayerService(PlayerService playerService) {
        GoCommand.playerService = playerService;
    }

    /**
     * Executes the go command for the specified player.
     *
     * @param playerId the ID of the player executing the command
     * @return the result of the command execution
     */
    public String execute(Long playerId) {
        if (!hasSecondWord()) {
            return "go where?";
        }

        String direction = getSecondWord();

        RoomId roomId = RoomSetting.roomIds.get(playerService.getCurrentRoom(playerId));
        Room currentRoom = RoomSetting.rooms.get(roomId);

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return "There is no door!";
        } else {
            Record.record(playerId, roomId);
            playerService.setCurrentRoom(playerId, RoomId.getRoomId(nextRoom.getName()));
            return nextRoom.getLongDescription();
        }
    }
}
