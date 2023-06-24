package com.wuwu.worldofzuulwuwu.zuul;

import org.springframework.stereotype.Component;

/**
 * The QuitCommand class represents a command to quit the game.
 * It extends the Command class and provides the logic to execute the command.
 *
 * This class assumes that the Command class is available and properly defined.
 *
 * Note: This class assumes that the hasSecondWord() method is implemented in the Command class.
 *
 * Example usage:
 * - QuitCommand quitCommand = new QuitCommand();
 * - String result = quitCommand.execute(playerId);
 *
 * Example output:
 * - If a second word is present: "Quit what?"
 * - If no second word is present: "Bye."
 *
 * Note: The execute method checks if a second word is present. If it is, it returns "Quit what?".
 * If no second word is present, it returns "Bye." as the farewell message.
 */
@Component
public class QuitCommand extends Command {
    /**
     * Executes the quit command.
     *
     * @param playerId the ID of the player executing the command
     * @return the result message of the command execution
     */
    public String execute(Long playerId) {
        if (hasSecondWord()) {
            return "Quit what?";
        } else {
            return "Bye.";
        }
    }
}
