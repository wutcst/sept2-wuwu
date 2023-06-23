package com.wuwu.worldofzuulwuwu.zuul;

import java.util.HashMap;

public class ItemSetting {

  private static HashMap<String, Integer> itemIdMap=new HashMap<>();
  private static HashMap<Integer, Item> itemMap=new HashMap<>();

  static {
    itemMap.put(1, new Item("gem", "This gem looks worth 100 million.", 1));
    itemMap.put(2, new Item("gold_cup", "This gold_cup used to contain holy water", 4));
    itemMap.put(3, new Item("cookie1", "The cookie can give you power.", 1));
    itemMap.put(4, new Item("lantern", "A tool that can allow you see things in darkness.", 2));
    itemMap.put(5, new Item("crown", "It seemed to belong to a king.", 2));
    itemMap.put(6, new Item("cookie2", "The cookie can give you power.", 1));
    itemMap.put(7, new Item("rune", "The rune will give you knowledge of ancient magic", 3));
    itemMap.put(8, new Item("sword", "A weapon that can kill a human, or a dead human.", 4));
    itemMap.put(9, new Item("ring", "The legendary magic ring used to be owned by a Hobbit", 1));

    itemIdMap.put("gem", 1);
    itemIdMap.put("gold_cup", 2);
    itemIdMap.put("cookie1", 3);
    itemIdMap.put("lantern", 4);
    itemIdMap.put("crown", 5);
    itemIdMap.put("cookie2", 6);
    itemIdMap.put("rune", 7);
    itemIdMap.put("sword", 8);
    itemIdMap.put("ring", 9);
  }

  public static Integer getId(String itemName){
    return itemIdMap.get(itemName);
  }

  public static Item getItem(Integer itemId){
    return itemMap.get(itemId);
  }


}
