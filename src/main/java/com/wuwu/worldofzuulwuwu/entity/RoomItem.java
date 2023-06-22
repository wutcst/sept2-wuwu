package com.wuwu.worldofzuulwuwu.entity;

import lombok.Data;

/**
 * @author:wangyuze
 * @create: 2023-06-22 20:09
 * @Description: 房间物品关系类
 */
@Data
public class RoomItem {
    private Long playerId;
    private Integer roomId;
    private Integer itemId;
    private Integer count;
}
