package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class FlyPlaneCommand implements Command {
    private InputOutput io;

    public FlyPlaneCommand(InputOutput io){
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1 || parts.length == 2 || parts.length == 3) return false;
        return
                ((parts[0].equalsIgnoreCase("fly")) &&
                (parts[1].equalsIgnoreCase("a")) &&
                (parts[2].equalsIgnoreCase("plane")));

    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var destination = input.substring(12);
        io.displayText("You fly " + destination + "...");
    }
}
