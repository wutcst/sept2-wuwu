package com.wuwu.worldofzuulwuwu.entity;

import lombok.Data;

/**
 * @author:wangyuze
 * @create: 2023-06-22 14:18
 * @Description: player class
 */

@Data
public class Player {
    private Long id;
    private String name;
    private String password;
    private Integer currentRoom;
    private Integer capacity;
}
