<<<<<<<< HEAD:src/main/java/zuul/Command.java
package zuul;
========
package com.wuwu.worldofzuulwuwu.zuul;

import org.springframework.stereotype.Component;

>>>>>>>> 656701185ab67113279f3127cbb7c3aa729f458b:src/main/java/com/wuwu/worldofzuulwuwu/zuul/Command.java

public abstract class Command
{
    private String secondWord;

    public Command()
    {
        secondWord = null;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean hasSecondWord()
    {
        return secondWord != null;
    }

    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }

    public abstract String execute(Long playerId);
}
