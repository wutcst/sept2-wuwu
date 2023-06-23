package zuul;

import java.util.List;

public class Inventory {
  private List<Item> itemList;

  public Boolean addItem(Item item){
    if(item!= null){
      itemList.add(item);
      return true;
    }
    return false;
  }

  public Boolean removeItem(Item item){
    if(item!=null){
      itemList.remove(item);
      return true;
    }
    return false;
  }

  public Item get(String name){
    for(Item item : itemList){
      if(name.equals(item.getName())){
        return item;
      }
    }
    return null;
  }

  public Boolean isEmpty(){
    return itemList.isEmpty();
  }

  public String getItemsString(){
    if(itemList.isEmpty()){
      return "This room has been cleared.";
    } else{
      String description = "After a minute of search, you find:\n";
      for(Item item : itemList){
        description += item.getName() + " *" + item.getDescription() + "\n";
      }
      return description;
    }
  }
}
