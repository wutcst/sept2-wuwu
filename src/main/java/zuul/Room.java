<<<<<<<< HEAD:src/main/java/zuul/Room.java
package zuul;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
========
package com.wuwu.worldofzuulwuwu.zuul;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
>>>>>>>> 656701185ab67113279f3127cbb7c3aa729f458b:src/main/java/com/wuwu/worldofzuulwuwu/zuul/Room.java
import java.util.Set;

@Slf4j
public class Room
{
    private String name;
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private Inventory items;

    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
        items = new Inventory();
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction)
    {
        log.info(getExitString());
        log.info(direction);
        log.info(exits.toString());
        return exits.get(direction);
    }

    public Inventory getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


