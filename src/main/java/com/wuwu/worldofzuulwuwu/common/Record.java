package com.wuwu.worldofzuulwuwu.common;

import com.wuwu.worldofzuulwuwu.zuul.RoomId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author:wangyuze
 * @create: 2023-06-23 16:04
 * @Description: 玩家房间位置记录
 */

public class Record {
    private static HashMap<Long, LinkedList<RoomId>> records=new HashMap<>();
    public static void record(Long player_id,RoomId roomId){
        LinkedList<RoomId> roomIdArrayList = records.get(player_id);
        if(roomIdArrayList==null){
            records.put(player_id,new LinkedList<RoomId>());
            records.get(player_id).addLast(roomId);
        }
        else{
            roomIdArrayList.addLast(roomId);
        }
    }
    public static RoomId back(Long player_id){
        LinkedList<RoomId> roomIdArrayList = records.get(player_id);
        if(roomIdArrayList==null || roomIdArrayList.isEmpty()){
            return RoomId.ENTRANCE;
        }
        else{
            RoomId roomId = roomIdArrayList.getLast();
            roomIdArrayList.removeLast();
            return roomId;
        }
    }
}
