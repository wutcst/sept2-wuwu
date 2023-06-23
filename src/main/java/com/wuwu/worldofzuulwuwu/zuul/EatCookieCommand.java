package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:wangyuze
 * @create: 2023-06-23 16:50
 * @Description: eat cookie
 */
@Component
public class EatCookieCommand extends Command {
    private static PlayerItemService playerItemService;
    private static PlayerService playerService;


    @Autowired
    public void setPlayerItemService (PlayerItemService playerItemService){
        EatCookieCommand.playerItemService = playerItemService;
    }

    @Autowired
    public void setPlayerService (PlayerService playerService){
        EatCookieCommand.playerService = playerService;
    }

    @Override
    public String execute(Long playerId) {
        //未指明要获取什么物品
        if(!hasSecondWord()){
            return "eat what?";
        }

        String secondWord = getSecondWord();
        if(secondWord.equals("cookie1") || secondWord.equals("cookie2")){
            Integer itemId = ItemSetting.getId(secondWord);
            Boolean ok = playerItemService.removeItem(playerId, secondWord);
            if(!ok){
                return "You don't have cookie in your backpack";
            }
            else{
                playerService.addCapacity(playerId, 10);
                return "Your backpack capacity has increased by 10";
            }
        }
        else{
            return "Good boys only eat cookies";
        }

    }
}
