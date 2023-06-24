package com.wuwu.worldofzuulwuwu.entity;

import lombok.Data;

/**
 * @author:wangyuze
 * @create: 2023-06-22 20:12
 * @Description: relationship between player and items
 */
@Data
public class PlayerItem {
    private Long playerId;
    private Integer id;
    private Integer count;
}
