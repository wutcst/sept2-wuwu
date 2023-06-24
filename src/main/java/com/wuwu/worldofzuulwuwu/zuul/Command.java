package com.wuwu.worldofzuulwuwu.zuul;

import org.springframework.stereotype.Component;

/**
 * The Command class represents an abstract command in the game.
 * It provides a basic structure for specific commands to extend from.
 * Commands are used in the Zuul framework of the game.
 *
 * This class is marked as a component to be managed by Spring.
 */
@Component
public abstract class Command {
    private String secondWord;

    /**
     * Creates a new instance of the Command class.
     * The secondWord is initially set to null.
     */
    public Command() {
        secondWord = null;
    }

    /**
     * Returns the second word of the command.
     *
     * @return the second word
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * Checks if the command has a second word.
     *
     * @return true if the command has a second word, false otherwise
     */
    public boolean hasSecondWord() {
        return secondWord != null;
    }

    /**
     * Sets the second word of the command.
     *
     * @param secondWord the second word to be set
     */
    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    /**
     * Executes the command for the specified player.
     *
     * @param playerId the ID of the player executing the command
     * @return the result of the command execution
     */
    public abstract String execute(Long playerId);
}
