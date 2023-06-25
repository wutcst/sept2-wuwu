package com.wuwu.worldofzuulwuwu.zuul;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Parser {
    private CommandWords commands;  // holds all valid command words

    public Parser() {
        commands = new CommandWords();
    }

    /**
     * Parses the input line and returns the corresponding Command object.
     *
     * @param inputLine the input line entered by the user
     * @return the Command object representing the user's command, or null if the command is not valid
     */
    public Command getCommand(String inputLine) {
        String word1 = null;
        String word2 = null;

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
            }
        }

        Command command = commands.get(word1);
        if (command != null) {
            command.setSecondWord(word2);
        }
        return command;
    }

    /**
     * Returns a string representation of all valid command words.
     *
     * @return a string containing all valid command words
     */
    public String showCommands() {
        return commands.showAll();
    }
}
