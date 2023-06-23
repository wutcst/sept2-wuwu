package com.wuwu.worldofzuulwuwu.zuul;

public class HelpCommand extends Command
{
    private CommandWords commandWords;

    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }

    @Override
    public String execute(Long playerId) {
        return null;
    }
}
