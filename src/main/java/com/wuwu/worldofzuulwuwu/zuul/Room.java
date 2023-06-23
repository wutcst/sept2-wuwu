package com.wuwu.worldofzuulwuwu.zuul;

import java.util.HashMap;
import java.util.Set;

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

