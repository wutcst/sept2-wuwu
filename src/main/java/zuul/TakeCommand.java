package zuul;

public class TakeCommand extends Command{

  @Override
  public boolean execute(Game game) {
    //未指明要获取什么物品
    if(!hasSecondWord()){
      System.out.println("take what?");
    }

    //从房间查找该物品
    String itemName = getSecondWord();
    Room currentRoom = game.getCurrentRoom();
    Item item = currentRoom.getItems().get(itemName);

    //返回提示信息
    if(item==null){
      System.out.println("There is no such item.");
    }else{
      currentRoom.getItems().removeItem(item);
      game.getInventory().addItem(item);
      System.out.println("You took " + item);
    }

    return false;
  }
}
