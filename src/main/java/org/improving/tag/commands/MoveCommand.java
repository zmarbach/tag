package org.improving.tag.commands;

import org.improving.tag.*;
import org.springframework.stereotype.Component;


@Component
public class MoveCommand extends BaseAliasedCommand {//takes the isValid and execute methods below because it is an implementor of Command interface
    private InputOutput io;
    private MovementStore movementStore;

    public MoveCommand(InputOutput io, MovementStore movementStore) {
        super(io,"move", "m", "mo", "mov");
        this.io = io;
        this.movementStore = movementStore;
    }

    @Override
    public String getCommandPart(String input) {
        var parts = input.split(" ");
        if (parts.length == 1) throw new UnsupportedOperationException(); //if there is only 1 string in the array, throw an exception. Catch it in isValid method on BaseALiasedCOmmand
        return parts[0];
    }

    @Override
    public String getErrorMessage() {
        return "That route is unavailable.";
    }

    @Override
    public void childExecute(String input, Game game) {
        input = input.trim();
        var destination = input.substring(input.indexOf(" ") + 1); //take the input and substring it. Set the starting location of the substring as the first space and then 1 character to the right, and get everything else after that


        if(game.getPlayer().getLocation().getAdversary() != null) {
            io.displayText("YOU SHALL NOT PASS!!!");
            io.displayText(game.getPlayer().getLocation().getAdversary().getName() + " emerges from the darkness. How will you proceed?");
            return;
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
        if (exit == null) throw new UnsupportedOperationException();//this will go to catch block of BaseAliasedCommand

        Location locationToStore = game.getPlayer().getLocation();
        var locationStack = movementStore.getLocationStack().push(locationToStore);

        game.getPlayer().setLocation(exit.getDestination());///this is where we SET the new location of the player after we move (the destination of the exit name or alias the user typed)
        io.displayText("You travel " + exit.getName() + ".");
    }
}
