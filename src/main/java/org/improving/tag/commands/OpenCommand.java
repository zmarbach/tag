package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
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
        io.displayText("You have found " + item); //when we concatenate item with a string, Java know that it needs to call the toString method for whatever the object is. item is an Item, so it looks at implementors of Item interface and finds the toString method on UniqueItems (which returns the name and description)
        //Java knows which actual implementor we are referring to EVEN if we dont specify above (not sure how but it does???)

        game.getPlayer().getInventory().addItem(item);

    }

    @Override
    public String getErrorMessage() {
        return "There is nothing to open in this room.";
    }
}

