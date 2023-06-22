package zuul;

public class LookCommand extends Command{

  @Override
  public boolean execute(Game game) {

    System.out.println(game.getCurrentRoom().getItemsString());

    return false;
  }
}
