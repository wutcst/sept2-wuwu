package com.wuwu.worldofzuulwuwu.zuul;

public class Item {
  private String name;
  private String description;
  private Integer weight;

  public Item() {
  }

  public Item(String name, String description, Integer weight) {
    this.name = name;
    this.description = description;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }
}
