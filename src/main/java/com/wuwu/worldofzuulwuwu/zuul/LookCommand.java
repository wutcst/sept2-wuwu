package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.entity.RoomItem;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The LookCommand class represents a command to look for items in the current room.
 * It retrieves the list of items in the current room and provides a description of each item.
 *
 * This class requires the RoomItemService and PlayerService to be autowired for accessing the game data.
 *
 * Example usage:
 * - LookCommand lookCommand = new LookCommand();
 * - String result = lookCommand.execute(playerId);
 *
 * Example output:
 * - You find:
 *   [gem] [This gem looks worth 100 million.] [1]
 *   [gold cup] [This gold cup used to contain holy water] [4]
 *   [cookie1] [The cookie can give you power.] [1]
 *
 * Note: The execute method retrieves the current room ID and gets the corresponding Room object from the RoomSetting class.
 * It then calls the roomItemService to retrieve the list of RoomItem objects for the current room.
 * The method iterates through the list of RoomItem objects and retrieves the corresponding Item object from the ItemSetting class.
 * It constructs a message with the item details and returns the message as a string.
 * If no items are found in the room, it returns a message indicating that nothing was found.
 *
 * Note: This class assumes that the Room, RoomItem, Item, RoomSetting, RoomItemService, and PlayerService classes are properly implemented and available.
 *
 * Note: This class assumes that the roomItemService and playerService beans are properly implemented and available.
 *
 * Note: This class assumes that the roomItemService.lookUpAllItems() method retrieves the list of RoomItem objects for the current room and player.
 *
 * Note: This class assumes that the RoomItem and Item classes have appropriate getters for retrieving item details.
 *
 * Note: This class assumes that the RoomSetting and ItemSetting classes have appropriate methods for accessing room and item information.
 *
 * Note: This class assumes that the RoomSetting and ItemSetting classes are properly implemented and available.
 *
 * Note: This class assumes that the Room and Item classes have appropriate constructors for creating instances of the classes.
 *
 * Note: This class assumes that the Room and Item classes have appropriate fields and methods for storing and retrieving item details.
 *
 * Note: This class assumes that the Room class provides a method to retrieve the long description of the room.
 */
@Component
public class LookCommand extends Command {

  private static RoomItemService roomItemService;
  private static PlayerService playerService;

  @Autowired
  public void setRoomItemService(RoomItemService roomItemService) {
    LookCommand.roomItemService = roomItemService;
  }

  @Autowired
  public void setPlayerService(PlayerService playerService) {
    LookCommand.playerService = playerService;
  }

  /**
   * Executes the look command by retrieving the current room and its items.
   * Constructs a message with the item details and returns the message as a string.
   * If no items are found in the room, returns a message indicating that nothing was found.
   *
   * @param playerId the ID of the player executing the command
   * @return a string message describing the items found in the current room
   */
  @Override
  public String execute(Long playerId) {
    Integer currentRoomId = playerService.getCurrentRoom(playerId);
    Room currentRoom = RoomSetting.rooms.get(RoomSetting.roomIds.get(currentRoomId));

    List<RoomItem> roomItemList = roomItemService.lookUpAllItems(playerId, currentRoom.getName());

    if (roomItemList.isEmpty()) {
      return "You find nothing in this room";
    }

    StringBuilder msg = new StringBuilder("You find:\n");

    for (RoomItem roomItem : roomItemList) {
      Integer itemId = roomItem.getId();
      Item item = ItemSetting.getItem(itemId);
      msg.append("[").append(item.getName()).append("] [").append(item.getDescription())
          .append("] [").append(item.getWeight()).append("]\n");
    }

    return msg.toString();
  }
}
