package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

@Component
public class OpenCommand extends BaseAliasedCommand {
    private InputOutput io;

    public OpenCommand(InputOutput io) {
        super(io, "open", "o");
        this.io = io;
    }

    @Override
    public void childExecute(String input, Game game) {
        var item = game.getPlayer().getLocation().openTreasureChest();
        io.displayText("You have found " + item); //Java knows to convert the item to a string, it automatically calls the toString method on UniqueItems (Java knows because the " + portion signifies that the result need to be a string)

        game.getPlayer().getInventory().addItem(item);

    }

    @Override
    public String getErrorMessage() {
        return "There is nothing to open in this room.";
    }
}

