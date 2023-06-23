package com.wuwu.worldofzuulwuwu.zuul;

import java.util.HashMap;
import java.util.Iterator;

public class CommandWords
{
    private HashMap<String, Command> commands;

    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("help", new HelpCommand(this));
        commands.put("quit", new QuitCommand());
        commands.put("look", new LookCommand());
        commands.put("take", new TakeCommand());
        commands.put("drop", new DropCommand());
    }

    public Command get(String word)
    {
        return (Command)commands.get(word);
    }

    public String showAll()
    {

        StringBuilder all= new StringBuilder();
        for (String s : commands.keySet()) {
            all.append(s).append(" ");
        }
        return all.toString();
    }
}
