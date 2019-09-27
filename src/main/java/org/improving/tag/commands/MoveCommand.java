package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.Location;
import org.springframework.stereotype.Component;

@Component
public class MoveCommand implements Command {//takes the isValid and execute methods below because it is an implementor of Command interface
    private InputOutput io;
    private Location location;

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

        if(game.getPlayer().getLocation().getAdversary() != null) {
            io.displayText("YOU SHALL NOT PASS!!!");
            io.displayText(game.getPlayer().getLocation().getAdversary().getName() + " emerges from the darkness. How will you proceed?");
            //return;
        }

        Exit exit = null;//checking to see if user input equals any exit name or alias
        for (var e: game.getPlayer().getLocation().getExits()) {
            if (e.getName().equalsIgnoreCase(destination)) {
                exit = e;
            }
            else {
                for (var a : e.getAliases()) {//getting all aliases for ALL exits at the location and checking them against user input...this is why we cant have same alias in 2 exits for the same Location (but it is ok in different Locations because only pulling in aliases for ONE location, each time we go through the loop))
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
        game.getPlayer().setLocation(exit.getDestination());///this is where we SET the new location of the player after we move (the destination of the exit name or alias the user typed)
        io.displayText("You travel " + exit.getName() + ".");
    }
}
