package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component

public class PackUpCommand extends BaseEmoteCommand {
    public PackUpCommand(InputOutput io) {
        super("You pack your bags.", io, "pack up", "pack");
    }
}
