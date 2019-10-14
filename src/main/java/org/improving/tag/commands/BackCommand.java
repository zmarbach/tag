package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.MovementStore;
import org.springframework.stereotype.Component;

@Component
public class BackCommand extends BaseAliasedCommand {
    private MovementStore movementStore;

    public BackCommand(InputOutput io, MovementStore movementStore) {
        super(io, "back", "b");
        this.movementStore = movementStore;
    }

    @Override
    public void childExecute(String input, Game game) {
        if (movementStore.getLocationStack().isEmpty()) {
            io.displayText("There is no location behind you. You cannot go back.");
        } else {
            var prevLocation = movementStore.getLocationStack().pop();
            if (game.getPlayer().getLocation() == prevLocation) {
                io.displayText("You cannot go back any further.");
            } else {
                var newLocationName = prevLocation.getName();
                game.getPlayer().setLocation(prevLocation);
                io.displayText("You have moved back to " + newLocationName + ".");
            }
        }
    }
}

