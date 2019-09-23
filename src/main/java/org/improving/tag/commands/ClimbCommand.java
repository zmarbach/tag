package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class ClimbCommand extends BaseEmoteCommand {

    public ClimbCommand(InputOutput io) {
        super("climb", "You climb up the cliff.", io);
    }
}
