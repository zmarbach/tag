package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component

public class PackUpCommand extends BaseEmoteCommand {
    public PackUpCommand(InputOutput io) {
        super("pack up", "You pack your bags.", io);
    }
}
