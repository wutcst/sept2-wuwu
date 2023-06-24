package com.wuwu.worldofzuulwuwu.zuul;

/**
 * The Item class represents an item in the game.
 * It contains information about the item's name, description, and weight.
 *
 * Items can be used, taken, or dropped by the player in the game.
 *
 * The Item class provides getters and setters for accessing and modifying the item's properties.
 *
 * Note: This class does not contain any game logic. It is a simple representation of an item.
 * The usage and functionality of items are implemented in other classes of the game.
 *
 * Note: This class does not extend any other class, as it is a standalone class representing an item.
 *
 * Note: This class does not have any Spring annotations, as it is not managed by Spring.
 * It is a basic POJO class used in the game's logic.
 *
 * @author:wangyuze
 * @create: 2023-06-23 15:53
 * @Description: Represents an item in the game
 */
public class Item {
  private String name;
  private String description;
  private Integer weight;

  /**
   * Constructs an empty item.
   */
  public Item() {
  }

  /**
   * Constructs an item with the specified name, description, and weight.
   *
   * @param name        the name of the item
   * @param description the description of the item
   * @param weight      the weight of the item
   */
  public Item(String name, String description, Integer weight) {
    this.name = name;
    this.description = description;
    this.weight = weight;
  }

  /**
   * Returns the name of the item.
   *
   * @return the name of the item
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the item.
   *
   * @param name the name of the item to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the description of the item.
   *
   * @return the description of the item
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the item.
   *
   * @param description the description of the item to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns the weight of the item.
   *
   * @return the weight of the item
   */
  public Integer getWeight() {
    return weight;
  }

  /**
   * Sets the weight of the item.
   *
   * @param weight the weight of the item to set
   */
  public void setWeight(Integer weight) {
    this.weight = weight;
  }
}
