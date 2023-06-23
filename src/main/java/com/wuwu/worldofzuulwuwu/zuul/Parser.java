package com.wuwu.worldofzuulwuwu.zuul;

import java.util.Scanner;

public class Parser
{
    private CommandWords commands;  // holds all valid command words

    public Parser()
    {
        commands = new CommandWords();
    }

    public Command getCommand(String inputLine)
    {
        String word1 = null;
        String word2 = null;

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
            }
        }

        Command command = commands.get(word1);
        if(command != null) {
            command.setSecondWord(word2);
        }
        return command;
    }

    public String showCommands()
    {
        return commands.showAll();
    }
}

