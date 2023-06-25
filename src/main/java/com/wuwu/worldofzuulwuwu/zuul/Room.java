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
public class Room {
    private String name;
    private String description;
    private HashMap<String, Room> exits; // stores exits of this room.
    private Inventory items;

    /**
     * Creates a new Room with the given description.
     *
     * @param description the description of the room
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new Inventory();
    }

    /**
     * Sets the exit for a given direction to the specified neighboring room.
     *
     * @param direction the direction of the exit
     * @param neighbor  the neighboring room
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * Returns the short description of the room.
     *
     * @return the short description of the room
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Returns the long description of the room, including the exits.
     *
     * @return the long description of the room
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Returns a string representation of the exits in the room.
     *
     * @return a string representation of the exits
     */
    private String getExitString() {
        StringBuilder returnString = new StringBuilder("Exits:");
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString.append(" ").append(exit);
        }
        return returnString.toString();
    }

    /**
     * Returns the neighboring room in the specified direction.
     *
     * @param direction the direction of the exit
     * @return the neighboring room, or null if no exit exists in the given direction
     */
    public Room getExit(String direction) {
        log.info(getExitString());
        log.info(direction);
        log.info(exits.toString());
        return exits.get(direction);
    }

    /**
     * Returns the inventory of items in the room.
     *
     * @return the inventory of items
     */
    public Inventory getItems() {
        return items;
    }

    /**
     * Returns the name of the room.
     *
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the room.
     *
     * @param name the name of the room
     */
    public void setName(String name) {
        this.name = name;
    }
}
