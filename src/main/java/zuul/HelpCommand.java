package zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

public class HelpCommand extends Command
{

    @Autowired
    private PlayerService playerService;
    private CommandWords commandWords;

    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }

    public String execute(Long playerId)
    {

        String playerName = playerService.getName(playerId);
        String msg = "";
        msg += "Your name is " + playerName + ".\n";
        msg += "You went down to the dungeon, a place is said to hide great treasure.\n";
        msg += "Your command words are:\n";
        msg += commandWords.showAll();
        return msg;
    }
}
