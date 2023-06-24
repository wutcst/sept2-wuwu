package com.wuwu.worldofzuulwuwu.entity;

import lombok.Data;

/**
 * @author:wangyuze
 * @create: 2023-06-22 20:09
 * @Description: relationship between rooms and items
 */
@Data
public class RoomItem {
    private Long playerId;
    private Integer roomId;
    private Integer id;
    private Integer count;
}
