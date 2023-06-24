package com.wuwu.worldofzuulwuwu.zuul;

import java.util.HashMap;

/**
 * The ItemSetting class is responsible for managing the items in the game.
 * It provides methods to retrieve item information based on item names or item IDs.
 *
 * The ItemSetting class contains a static initialization block that populates the item map and item ID map.
 * The item map stores Item objects with their corresponding item IDs as keys.
 * The item ID map stores item names as keys and their corresponding item IDs as values.
 *
 * Note: This class assumes that the Item class is available and properly defined.
 *
 * Note: This class does not handle any game logic related to items.
 * It only provides a mapping of item names to item IDs and vice versa.
 *
 * Note: This class uses static fields and methods to allow access to the item information without creating an instance of the class.
 *
 * Note: The initialization block is executed when the class is loaded, ensuring that the item maps are populated before they are accessed.
 *
 * Example usage:
 * - Integer itemId = ItemSetting.getId("gem"); // Get the item ID for the item name "gem"
 * - Item item = ItemSetting.getItem(1); // Get the Item object for the item ID 1
 *
 * Example item retrieval:
 * - Integer itemId = ItemSetting.getId(itemName); // Get the item ID for the specified item name
 * - Item item = ItemSetting.getItem(itemId); // Get the Item object for the specified item ID
 *
 * Note: This class assumes that the item names and item IDs are unique and consistent.
 *
 * Note: The item maps are initialized with a predefined set of items. Additional items can be added or modified in the static initialization block.
 *
 * @author:wangyuze
 * @create: 2023-06-23 15:57
 * @Description: Manages the items in the game
 */
public class ItemSetting {

  private static HashMap<String, Integer> itemIdMap = new HashMap<>();
  private static HashMap<Integer, Item> itemMap = new HashMap<>();

  // Static initialization block to populate the item maps
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

  /**
   * Retrieves the item ID for the specified item name.
   *
   * @param itemName the name of the item
   * @return the item ID if found, or null if not found
   */
  public static Integer getId(String itemName) {
    return itemIdMap.get(itemName);
  }

  /**
   * Retrieves the Item object for the specified item ID.
   *
   * @param itemId the ID of the item
   * @return the Item object if found, or null if not found
   */
  public static Item getItem(Integer itemId) {
    return itemMap.get(itemId);
  }
}
