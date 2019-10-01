package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class InventoryCommand extends BaseAliasedCommand {


    public InventoryCommand(InputOutput io) {
        super   (io, "inventory", "i", "in", "inv");
        //do not technically need to initialize io because gets io from BaseAliasedCommand...
        // we changed BaseAliasedCommand to require an io, so now its subclasses can use io without needing a class level variable
    }
    @Override
    public void childExecute(String input, Game game) {
        if (game.getPlayer().getInventory().isEmpty()) {
            io.displayText("You are carrying nothing.");
        } else {
            io.displayText(game.getPlayer().getInventory().getInventoryDisplay());
        }
    }
}
