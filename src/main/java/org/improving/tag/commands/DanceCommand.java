package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class DanceCommand extends BaseEmoteCommand {
    public DanceCommand(InputOutput io, String...aliases) {
        super   ("You dance around.", io, "dance", "d");
    }
}

//if we wanted to make it so that users could type different aliases for dance command, then i would have to change the relationship and
//make Dance Command Extend BaseALIASEDCommand, so that I can push all aliases to the isValid method on BaseAlasedCommand, then take the execute method
//from BaseEmoteCommand and paste it here ON DanceCommand.
// (would also have to have to hand DanceCOmmand an io by doing this.io = io in the contrcutor and   making a private InputOutput variable at top of class

//YES, could do this, but Tim suggests actually making BaseEMOTECommand a child of BaseALIASEDCommand and restructure that way (essentially just adjust relationships to add another rung to the inheritance ladder so to speak)