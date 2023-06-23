package zuul;

import com.wuwu.worldofzuulwuwu.service.impl.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

public class GoCommand extends Command
{
    @Autowired
    private PlayerService playerService;

    public String execute(Long playerId)
    {
        if(!hasSecondWord()) {
            return "go where?";
        }

        String direction = getSecondWord();


        Room currentRoom = RoomSetting.rooms.get(playerService.getCurrentRoom(playerId));

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return "There is no door!";
        }
        else {
            game.setCurrentRoom(nextRoom);
            System.out.println(nextRoom.getLongDescription());
        }

        return false;
    }
}
