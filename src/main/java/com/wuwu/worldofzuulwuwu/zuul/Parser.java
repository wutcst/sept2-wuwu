<<<<<<<< HEAD:src/main/java/zuul/Parser.java
package zuul;
========
package com.wuwu.worldofzuulwuwu.zuul;
>>>>>>>> 656701185ab67113279f3127cbb7c3aa729f458b:src/main/java/com/wuwu/worldofzuulwuwu/zuul/Parser.java

import com.wuwu.worldofzuulwuwu.zuul.Command;
import com.wuwu.worldofzuulwuwu.zuul.CommandWords;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
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

