package com.wuwu.worldofzuulwuwu.zuul;

/**
 * The HelpCommand class represents a command to display the available commands in the game.
 * It extends the Command class and is used in the game's Zuul framework.
 *
 * The HelpCommand takes a CommandWords object as a parameter in its constructor.
 * The CommandWords object contains all the available commands in the game.
 *
 * When executed, the HelpCommand returns a string that lists all the available commands.
 *
 * Note: The implementation of the execute() method is empty in this class, as it is not needed for the HelpCommand.
 * The HelpCommand's functionality is implemented in the Zuul framework.
 *
 * @author:wangyuze
 * @create: 2023-06-23 15:53
 * @Description: Command to display the available commands
 */
public class HelpCommand extends Command {
    private CommandWords commandWords;

    /**
     * Creates a HelpCommand with the specified CommandWords object.
     *
     * @param words the CommandWords object containing the available commands
     */
    public HelpCommand(CommandWords words) {
        commandWords = words;
    }

    /**
     * Executes the help command for the specified player.
     * This method is empty as the help command's functionality is implemented in the Zuul framework.
     *
     * @param playerId the ID of the player executing the command
     * @return null (no result as the functionality is implemented in the framework)
     */
    @Override
    public String execute(Long playerId) {
        return null;
    }
}
