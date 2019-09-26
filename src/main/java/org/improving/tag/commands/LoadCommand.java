package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LoadCommand implements Command {
    private InputOutput io;
    private SaveGameFactory sgf;

    public LoadCommand (InputOutput io, SaveGameFactory sgf) {
        this.io = io;
        this.sgf = sgf;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if(input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("load");
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim().substring(5);
        sgf.load(input, game);
        io.displayText("You loaded: " + input);
        String location = game.getPlayer().getLocation().getName();
        io.displayText("You are now at " + location);

    }
}
