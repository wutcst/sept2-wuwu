package com.wuwu.worldofzuulwuwu.entity;

import lombok.Data;

/**
 * @author:wangyuze
 * @create: 2023-06-22 20:12
 * @Description: 玩家物品关系类
 */
@Data
public class PlayerItem {
    private Long playerId;
    private Integer id;
    private Integer count;
}
