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

    @ Override// can override methods on INTERFACE that it implements (just like it can override a method on a super it extends)
    public boolean isValid(String input, Game game) {
        return (input == null ? "" : input).trim().equalsIgnoreCase(cmdText);//trim is here cuz single responsibility
        //always put "" as the true value because no likely someone will create Command that looks for "". dont put "nothing" cuz someone might create a NothingCommand, and it would incorrectly run that COmmand instead of returning null.
    }
    @ Override
    public void execute(String input, Game game) {

        io.displayText(cmdResponse);
    }
}
