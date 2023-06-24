package com.wuwu.worldofzuulwuwu.common;

import com.wuwu.worldofzuulwuwu.zuul.RoomId;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class for recording player room positions.
 */
public class Record {
    private static HashMap<Long, LinkedList<RoomId>> records = new HashMap<>();

    /**
     * Records the player's room position.
     *
     * @param playerId The ID of the player.
     * @param roomId   The ID of the room.
     */
    public static void record(Long playerId, RoomId roomId) {
        LinkedList<RoomId> roomIdList = records.get(playerId);
        if (roomIdList == null) {
            records.put(playerId, new LinkedList<>());
            records.get(playerId).addLast(roomId);
        } else {
            roomIdList.addLast(roomId);
        }
    }

    /**
     * Returns the previous room of the player and removes it from the record.
     *
     * @param playerId The ID of the player.
     * @return The ID of the previous room.
     */
    public static RoomId back(Long playerId) {
        LinkedList<RoomId> roomIdList = records.get(playerId);
        if (roomIdList == null || roomIdList.isEmpty()) {
            return RoomId.ENTRANCE;
        } else {
            RoomId roomId = roomIdList.getLast();
            roomIdList.removeLast();
            return roomId;
        }
    }
}
