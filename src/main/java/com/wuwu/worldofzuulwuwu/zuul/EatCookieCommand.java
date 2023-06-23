package com.wuwu.worldofzuulwuwu.zuul;

import com.wuwu.worldofzuulwuwu.service.PlayerItemService;
import com.wuwu.worldofzuulwuwu.service.PlayerService;
import com.wuwu.worldofzuulwuwu.service.RoomItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:wangyuze
 * @create: 2023-06-23 16:50
 * @Description: eat cookie
 */
public class EatCookieCommand extends Command {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerItemService playerItemService;

    @Override
    public String execute(Long playerId) {
        //未指明要获取什么物品
        if(!hasSecondWord()){
            return "eat what?";
        }

        String secondWord = getSecondWord();
        if(secondWord.equals("cookie")){
            Integer itemId = ItemSetting.getId("cookie");
            Boolean ok = playerItemService.removeItem(playerId, "cookie");
            if(!ok){
                return "You don't have cookie in your backpack";
            }
            else{
                return "Your backpack capacity has increased by 10";
            }
        }
        else{
            return "Good boys only eat cookies";
        }

    }
}
