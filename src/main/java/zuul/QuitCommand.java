package zuul;

public class QuitCommand extends Command
{
    public String execute(Long playerId)
    {
        if(hasSecondWord()) {
            return "Quit what?";
        }
        else {
            return "Bye.";
        }
    }
}
