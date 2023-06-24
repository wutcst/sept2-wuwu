package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.mapper.PlayerItemDao;
import com.wuwu.worldofzuulwuwu.zuul.Item;
import com.wuwu.worldofzuulwuwu.zuul.ItemSetting;
import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The PlayerItemServiceImpl class is an implementation of the PlayerItemService interface.
 * It provides methods to manage player items.
 */
@Service
public class PlayerItemServiceImpl implements PlayerItemService {

  @Autowired
  private PlayerItemDao playerItemDao;

  @Autowired
  private PlayerDao playerDao;

  /**
   * Adds an item to the player's inventory.
   *
   * @param playerId The ID of the player.
   * @param itemName The name of the item to add.
   * @return {@code true} if the item was successfully added, {@code false} otherwise.
   */
  @Override
  public Boolean addItem(Long playerId, String itemName) {
    Player player = playerDao.findById(playerId);
    Integer capacity = player.getCapacity();

    Integer itemWeight = ItemSetting.getItem(ItemSetting.getId(itemName)).getWeight();

    capacity -= itemWeight;
    player.setCapacity(capacity);

    playerDao.update(player);

    PlayerItem playerItem = new PlayerItem();
    playerItem.setPlayerId(playerId);
    playerItem.setId(ItemSetting.getId(itemName));
    playerItem.setCount(1);

    int playerItem1 = playerItemDao.save(playerItem);

    return playerItem1 > 0;
  }

  /**
   * Removes an item from the player's inventory.
   *
   * @param playerId The ID of the player.
   * @param itemName The name of the item to remove.
   * @return {@code true} if the item was successfully removed, {@code false} otherwise.
   */
  @Override
  public Boolean removeItem(Long playerId, String itemName) {
    Player player = playerDao.findById(playerId);
    Integer capacity = player.getCapacity();

    Integer itemWeight = ItemSetting.getItem(ItemSetting.getId(itemName)).getWeight();

    capacity += itemWeight;
    player.setCapacity(capacity);

    playerDao.update(player);

    Integer itemId = ItemSetting.getId(itemName);

    PlayerItem playerItem = new PlayerItem();
    playerItem.setPlayerId(playerId);
    playerItem.setId(itemId);

    return playerItemDao.delete(playerItem) > 0;
  }

  /**
   * Retrieves a description of all items in the player's inventory.
   *
   * @param playerId The ID of the player.
   * @return The description of the player's items.
   */
  @Override
  public String getItemsDescription(Long playerId) {
    List<PlayerItem> playerItems = playerItemDao.findAll(playerId);
    StringBuilder msg = new StringBuilder();
    if (playerItems.isEmpty()) {
      msg.append("You don't have anything.");
      return msg.toString();
    }

    msg.append("You have the following items:\n");
    for (PlayerItem playerItem : playerItems) {
      Item item = ItemSetting.getItem(playerItem.getId());
      msg.append("[").append(item.getName()).append("] [").append(item.getDescription())
          .append("] [").append(item.getWeight()).append("]\n");

    }

    Player player = playerDao.findById(playerId);
    msg.append("Your capacity is ").append(player.getCapacity());
    return msg.toString();
  }
}
