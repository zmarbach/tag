package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class InventoryCommand extends BaseEmoteCommand {

    public InventoryCommand(InputOutput io, String...aliases) {
        super   ("You are carrying nothing.", io, "inventory", "i");
    }
}
