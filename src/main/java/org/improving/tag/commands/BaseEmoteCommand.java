package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

public abstract class BaseEmoteCommand implements Command {
    private String cmdText;
    private String cmdResponse;
    private InputOutput io;

    public BaseEmoteCommand(String cmdText, String cmdResponse, InputOutput io) {
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
        this.io = io;
    }

    @ Override
    public boolean isValid(String input, Game game) {
        //if(input == null) return false; //don't need ELSE after this "if" because it RETURNS out if the method if this is true. could put else, but waste of space
        return (input == null ? "" : input).trim().equalsIgnoreCase(cmdText);//trim is here cuz single responsibility
        //always put "" as the true value because no likely someone will create Command that looks for "". dont put "nothing" cuz someone might create a NothingCommand, and it would incorrectly run that COmmand instead of returning null.
    }
    @ Override
    public void execute(String input, Game game) {
        io.displayText(cmdResponse);
    }
}
