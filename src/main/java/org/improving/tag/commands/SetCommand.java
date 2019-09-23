package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SetCommand implements Command {
    private InputOutput io;

    public SetCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        if (input.contains("=")) {
            var parts = input.split("=");
            if (parts.length == 1) {
                return false; }
            return parts[0].equalsIgnoreCase("@set name");
        }
        return false;}

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var name = input.substring(10);
        game.getPlayer().setName(name);
        io.displayText("Your name is now " + name + ".");
    }
}
