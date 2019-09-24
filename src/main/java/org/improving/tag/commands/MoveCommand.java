package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class MoveCommand implements Command {//takes the isValid and execute methods below because it is an implementor of Command interface
    private InputOutput io;

    public MoveCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if(input == null) return false; //must have this cuz cant trim NULL
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1) return false;//if there is only 1 string in the array, then isValid is FALSE , so NOT valid command, so skips to next part of loop in Game and, not "exit", so returns "Huh?".
        return parts[0].equalsIgnoreCase("move");

        //there has to be a at least one other word, needs to be another word in the string.
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var destination = input.substring(5);

        Exit exit = null;//checking to see if user input equals any exit name or alias
        for (var e: game.getPlayer().getLocation().getExits()) {
            if (e.getName().equalsIgnoreCase(destination)) {
                exit = e;
            }
            else {
                for (var a : e.getAliases()) {
                    if (a.equalsIgnoreCase(destination)) {
                        exit = e;
                        break;
                    }
                }
            }
            if (exit != null) break;
        }
        if (exit == null) {
            io.displayText("This route is unavailable.");
            return;
        }
        game.getPlayer().setLocation(exit.getDestination());
        io.displayText("You travel " + exit.getName() + ".");
    }
}
