package com.wuwu.worldofzuulwuwu.entity;

import lombok.Data;

/**
 * @author:wangyuze
 * @create: 2023-06-22 14:18
 * @Description: 玩家类
 */

@Data
public class Player {
    private Long id;
    private String name;
    private String password;
}
