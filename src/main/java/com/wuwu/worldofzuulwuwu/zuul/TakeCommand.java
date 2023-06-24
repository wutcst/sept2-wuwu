package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The TakeCommand class represents a command to take an item in the game.
 * It is a component managed by Spring.
 */
@Component
public class TakeCommand extends Command {

  private static PlayerItemService playerItemService;
  private static RoomItemService roomItemService;
  private static PlayerService playerService;

  /**
   * Sets the room item service dependency.
   *
   * @param roomItemService The room item service.
   */
  @Autowired
  public void setRoomItemService(RoomItemService roomItemService) {
    TakeCommand.roomItemService = roomItemService;
  }

  /**
   * Sets the player service dependency.
   *
   * @param playerService The player service.
   */
  @Autowired
  public void setPlayerService(PlayerService playerService) {
    TakeCommand.playerService = playerService;
  }

  /**
   * Sets the player item service dependency.
   *
   * @param playerItemService The player item service.
   */
  @Autowired
  public void setPlayerItemService(PlayerItemService playerItemService) {
    TakeCommand.playerItemService = playerItemService;
  }

  /**
   * Executes the take command.
   *
   * @param playerId The ID of the player executing the command.
   * @return The result of the command execution.
   */
  @Override
  public String execute(Long playerId) {
    // Check if the second word (item name) is specified
    if (!hasSecondWord()) {
      return "take what?";
    }

    Integer roomId = playerService.getCurrentRoom(playerId);
    Room currentRoom = RoomSetting.rooms.get(RoomSetting.roomIds.get(roomId));
    String itemName = getSecondWord();

    Item item = ItemSetting.getItem(ItemSetting.getId(itemName));

    if (item == null) {
      return "There is no such item.";
    } else {
      Integer capacity = playerService.getCapacity(playerId);
      if (capacity < ItemSetting.getItem(ItemSetting.getId(itemName)).getWeight()) {
        return "You don't have enough capacity.";
      }

      playerItemService.addItem(playerId, itemName);
      roomItemService.removeItem(playerId, currentRoom.getName(), itemName);
      return "You took " + itemName;
    }
  }
}
