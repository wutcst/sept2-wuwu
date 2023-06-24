package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The ItemsCommand class represents a command in the game to display the player's items.
 * It extends the Command class and overrides the execute method.
 *
 * The ItemsCommand class is responsible for retrieving the player's items using the PlayerItemService,
 * and returning a string representation of the items' description.
 *
 * The ItemsCommand class is a Spring component and is managed by Spring.
 * It is used to handle the "items" command in the game.
 *
 * Note: This class assumes that the PlayerItemService is autowired and available for use.
 *
 * Note: This class does not handle any game logic related to items.
 * It delegates the task of retrieving item information to the PlayerItemService.
 *
 * @author:wangyuze
 * @create: 2023-06-23 15:53
 * @Description: Represents a command to display the player's items
 */
public class ItemsCommand extends Command {

  private static PlayerItemService playerItemService;

  /**
   * Sets the PlayerItemService dependency using Spring autowiring.
   *
   * @param playerItemService the PlayerItemService to set
   */
  @Autowired
  public void setPlayerItemService(PlayerItemService playerItemService) {
    ItemsCommand.playerItemService = playerItemService;
  }

  /**
   * Executes the items command for the specified player.
   * Retrieves the player's items using the PlayerItemService and returns a string representation of the items' description.
   *
   * @param playerId the ID of the player
   * @return a string representation of the player's items
   */
  @Override
  public String execute(Long playerId) {
    return playerItemService.getItemsDescription(playerId);
  }
}
