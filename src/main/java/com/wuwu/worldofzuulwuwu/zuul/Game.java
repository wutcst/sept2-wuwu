/**
 * The Game class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a simple text-based adventure game. Users can explore a maze of rooms.
 * You can extend the functionality of this game to make it more interesting!
 *
 * To start playing the game, a user needs to create an instance of the Game class and call the "play" method.
 *
 * An instance of the Game class will create and initialize all other classes: it creates all the rooms
 * and connects them into a maze; it creates the parser to receive user input and convert it into commands
 * to run the game.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 1.0
 */
package com.wuwu.worldofzuulwuwu.zuul;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Inventory inventory;

    public Game() {
        parser = new Parser();
    }

    /**
     * Prints the welcome message when the game starts.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Returns the current room.
     *
     * @return the current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the current room.
     *
     * @param room the room to be set as the current room
     */
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * Returns the player's inventory.
     *
     * @return the player's inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
}
