package com.wuwu.worldofzuulwuwu.common;

import com.wuwu.worldofzuulwuwu.zuul.RoomId;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author:wangyuze
 * @create: 2023-06-23 16:04
 * @Description: 玩家房间位置记录
 */
public class Record {
    private static HashMap<Long, ArrayList<RoomId>> records=new HashMap<>();
    public void record(Long player_id,RoomId roomId){
        ArrayList<RoomId> roomIdArrayList = records.get(player_id);
        if(roomIdArrayList==null){
            records.put(player_id,new ArrayList<RoomId>());
        }
        else{
            roomIdArrayList.add(roomId);
        }
    }
}
