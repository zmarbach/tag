package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends BaseAliasedCommand {
    private InputOutput io; //had to make variable for io (so we can use it below)...BaseEmote used to hold it for us when it was old look command that extended BaseEmote

    public LookCommand(InputOutput io) {
        super(io, "look", "where am i", "whereami", "?donde estoy?");
        this.io = io;

        //took entire isValid method off of this and moved it to BaseAliasCommand, where we pass aliases through super above.
        //BUT Look still handles the EXECUTE
    }

    @Override
    public void execute(String input, Game game) {
        var location = game.getPlayer().getLocation();
        io.displayText(location.getName());
        io.displayText(location.getDescription());
        io.displayText(location.getTreasureChest());
        io.displayNewLine();
        io.displayText("Exits:");

        for (var Exit: location.getExits()){
            io.displayText("  "+ Exit.getName());
        }
    }
}
