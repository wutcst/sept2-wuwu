package com.wuwu.worldofzuulwuwu.zuul;

import java.util.HashMap;

/**
 * The CommandWords class represents a collection of command words in the game.
 * It maps command words to their corresponding Command objects.
 */
public class CommandWords {
    private HashMap<String, Command> commands;

    /**
     * Creates a new instance of the CommandWords class.
     * Initializes the HashMap with the command words and their corresponding Command objects.
     */
    public CommandWords() {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("help", new HelpCommand(this));
        commands.put("quit", new QuitCommand());
        commands.put("look", new LookCommand());
        commands.put("take", new TakeCommand());
        commands.put("drop", new DropCommand());
        commands.put("back", new BackCommand());
        commands.put("eat", new EatCookieCommand());
        commands.put("items", new ItemsCommand());
    }

    /**
     * Retrieves the Command object associated with the specified command word.
     *
     * @param word the command word
     * @return the Command object associated with the command word, or null if not found
     */
    public Command get(String word) {
        return commands.get(word);
    }

    /**
     * Returns a string representation of all the command words available in the game.
     *
     * @return a string containing all the command words
     */
    public String showAll() {
        StringBuilder all = new StringBuilder();
        for (String s : commands.keySet()) {
            all.append(s).append(" ");
        }
        return all.toString();
    }
}
