package com.wuwu.worldofzuulwuwu.service.impl;

import com.wuwu.worldofzuulwuwu.entity.Player;
import com.wuwu.worldofzuulwuwu.entity.PlayerItem;
import com.wuwu.worldofzuulwuwu.mapper.PlayerDao;
import com.wuwu.worldofzuulwuwu.mapper.PlayerItemDao;
import com.wuwu.worldofzuulwuwu.zuul.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.wuwu.worldofzuulwuwu.zuul.ItemSetting;
import org.springframework.stereotype.Service;

@Service
public class PlayerItemServiceImpl implements com.wuwu.worldofzuulwuwu.service.PlayerItemService {

  @Autowired
  private PlayerItemDao playerItemDao;

  @Autowired
  private PlayerDao playerDao;

  public Boolean addItem(Long playerId, String itemName){

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

  public Boolean removeItem(Long playerId, String itemName){

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

  @Override
  public String getItemsDescription(Long playerId) {
    List<PlayerItem> playerItems = playerItemDao.findAll(playerId);
    StringBuilder msg = new StringBuilder();
    if(playerItems.isEmpty()){
      msg.append("You don't have anything.");
      return msg.toString();
    }

    msg.append("You have following items: \n");
    for(PlayerItem playerItem : playerItems){
      Item item = ItemSetting.getItem(playerItem.getId());
      msg.append("[").append(item.getName()).append("] [").append(item.getDescription())
          .append("] [").append(item.getWeight()).append("]\n");

    }

    Player player = playerDao.findById(playerId);
    msg.append("Your capacity is ").append(player.getCapacity());
    return msg.toString();
  }
}
