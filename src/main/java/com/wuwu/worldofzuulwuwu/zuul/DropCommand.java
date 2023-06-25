package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The DropCommand class represents a command to drop an item in the game.
 * It is a component managed by Spring and is used in the game's Zuul framework.
 */
@Component
public class DropCommand extends Command {

  private static PlayerItemService playerItemService;
  private static RoomItemService roomItemService;
  private static PlayerService playerService;

  /**
   * Sets the room item service using Spring's dependency injection.
   *
   * @param roomItemService the room item service to be set
   */
  @Autowired
  public void setRoomItemService(RoomItemService roomItemService) {
    DropCommand.roomItemService = roomItemService;
  }

  /**
   * Sets the player service using Spring's dependency injection.
   *
   * @param playerService the player service to be set
   */
  @Autowired
  public void setPlayerService(PlayerService playerService) {
    DropCommand.playerService = playerService;
  }

  /**
   * Sets the player item service using Spring's dependency injection.
   *
   * @param playerItemService the player item service to be set
   */
  @Autowired
  public void setPlayerItemService(PlayerItemService playerItemService) {
    DropCommand.playerItemService = playerItemService;
  }

  /**
   * Executes the drop command for the specified player.
   *
   * @param playerId the ID of the player executing the command
   * @return the result of the command execution
   */
  @Override
  public String execute(Long playerId) {

    if (!hasSecondWord()) {
      return "drop what?";
    }

    Integer roomId = playerService.getCurrentRoom(playerId);
    Room currentRoom = RoomSetting.rooms.get(RoomSetting.roomIds.get(roomId));
    String itemName = getSecondWord();

    Item item = ItemSetting.getItem(ItemSetting.getId(itemName));
    if (item == null) {
      return "You don't own this item.";
    } else {
      playerItemService.removeItem(playerId, itemName);
      roomItemService.addItem(playerId, currentRoom.getName(), itemName);
      return "You dropped " + itemName;
    }

  }
}
