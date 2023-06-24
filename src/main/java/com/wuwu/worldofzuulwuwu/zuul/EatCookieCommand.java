package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The EatCookieCommand class represents a command to eat a cookie in the game.
 * It is a component managed by Spring and is used in the game's Zuul framework.
 *
 * @author: wangyuze
 * @create: 2023-06-23 16:50
 * @Description: Command for eating a cookie
 */
@Component
public class EatCookieCommand extends Command {
    private static PlayerItemService playerItemService;
    private static PlayerService playerService;

    /**
     * Sets the player item service using Spring's dependency injection.
     *
     * @param playerItemService the player item service to be set
     */
    @Autowired
    public void setPlayerItemService(PlayerItemService playerItemService) {
        EatCookieCommand.playerItemService = playerItemService;
    }

    /**
     * Sets the player service using Spring's dependency injection.
     *
     * @param playerService the player service to be set
     */
    @Autowired
    public void setPlayerService(PlayerService playerService) {
        EatCookieCommand.playerService = playerService;
    }

    /**
     * Executes the eat cookie command for the specified player.
     *
     * @param playerId the ID of the player executing the command
     * @return the result of the command execution
     */
    @Override
    public String execute(Long playerId) {
        if (!hasSecondWord()) {
            return "eat what?";
        }

        String secondWord = getSecondWord();
        if (secondWord.equals("cookie1") || secondWord.equals("cookie2")) {
            Integer itemId = ItemSetting.getId(secondWord);
            Boolean ok = playerItemService.removeItem(playerId, secondWord);
            if (!ok) {
                return "You don't have cookie in your backpack";
            } else {
                playerService.addCapacity(playerId, 10);
                return "Your backpack capacity has increased by 10";
            }
        } else {
            return "Good boys only eat cookies";
        }
    }
}
