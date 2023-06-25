package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("playerService")
@Slf4j
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  private PlayerDao playerDao;
  @Autowired
  private RoomItemService roomItemService;

  /**
   * Registers a new player.
   *
   * @param player The player to register.
   * @return {@code true} if the player was successfully registered, {@code false} otherwise.
   */
  @Override
  public Boolean register(Player player) {
    Player existingPlayer = playerDao.findByName(player.getName());
    log.info("player: {}", existingPlayer);
    if (existingPlayer != null) {
      return false;
    }
    int result = playerDao.save(player);
    roomItemService.addItem(player.getId(), "cave", "gem");
    roomItemService.addItem(player.getId(), "cookie_room", "cookie1");
    roomItemService.addItem(player.getId(), "treasure_room", "gold_cup");
    roomItemService.addItem(player.getId(), "lobby", "lantern");
    roomItemService.addItem(player.getId(), "weapon_room", "sword");
    roomItemService.addItem(player.getId(), "jail", "cookie2");
    roomItemService.addItem(player.getId(), "jail", "crown");
    roomItemService.addItem(player.getId(), "reading_room", "rune");
    roomItemService.addItem(player.getId(), "exit6", "ring");
    return result > 0;
  }

  /**
   * Logs in a player.
   *
   * @param player The player to log in.
   * @return The ID of the player if the login is successful, {@code null} otherwise.
   */
  @Override
  public Long login(Player player) {
    Player existingPlayer = playerDao.findByName(player.getName());
    log.info("Player: {}", player);
    log.info("Existing Player: {}", existingPlayer);
    if (existingPlayer.getPassword().equals(player.getPassword())) {
      return existingPlayer.getId();
    } else {
      return null;
    }
  }

  /**
   * Retrieves the ID of the current room the player is in.
   *
   * @param id The ID of the player.
   * @return The ID of the current room.
   */
  @Override
  public Integer getCurrentRoom(Long id) {
    Player player = playerDao.findById(id);
    return player.getCurrentRoom();
  }

  /**
   * Sets the current room for the player.
   *
   * @param id     The ID of the player.
   * @param roomId The ID of the room to set as the current room.
   * @return {@code true} if the current room was successfully set, {@code false} otherwise.
   */
  @Override
  public Boolean setCurrentRoom(Long id, Integer roomId) {
    Player player = playerDao.findById(id);
    player.setCurrentRoom(roomId);
    return playerDao.update(player) > 0;
  }

  /**
   * Retrieves the name of the player.
   *
   * @param id The ID of the player.
   * @return The name of the player.
   */
  @Override
  public String getName(Long id) {
    Player player = playerDao.findById(id);
    return player.getName();
  }

  /**
   * Retrieves the capacity of the player.
   *
   * @param id The ID of the player.
   * @return The capacity of the player.
   */
  @Override
  public Integer getCapacity(Long id) {
    Player player = playerDao.findById(id);
    return player.getCapacity();
  }

  /**
   * Increases the capacity of the player by the specified increment.
   *
   * @param id        The ID of the player.
   * @param increment The amount by which to increase the capacity.
   */
  @Override
  public void addCapacity(Long id, Integer increment) {
    Player player = playerDao.findById(id);
    player.setCapacity(player.getCapacity() + increment);
  }
}
