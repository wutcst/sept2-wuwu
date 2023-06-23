package com.wuwu.worldofzuulwuwu.zuul;

public class DropCommand extends Command{

  @Override
  public boolean execute(Game game) {

    if(!hasSecondWord()){
      System.out.println("drop what?");
      return false;
    }

    Room currentRoom = game.getCurrentRoom();
    Inventory inventory = game.getInventory();
    String itemName = getSecondWord();

    Item item = inventory.get(itemName);
    if(item==null){
      System.out.println("You don't own this item.");
    }else{
      inventory.removeItem(item);
      currentRoom.getItems().addItem(item);
      System.out.println("You dropped " + itemName);
    }

    return false;
  }
}
