package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] Commands; //Spring creates this array of all our commands. It scans for '@Component' and if that class implements Command, then Spring puts that class into the Commands[];
    private InputOutput io;
    private Player p;

    private Location startingLocation;
    private final SaveGameFactory saveFactory;
    private List<Location> locationList;


    public Game(Command[] Commands, InputOutput io, SaveGameFactory saveFactory, WorldBuilder worldBuilder) throws RuntimeException {
        startingLocation = worldBuilder.buildWorld();
        locationList = worldBuilder.getLocationList();
        this.Commands = Commands;
        this.io = io;
        this.saveFactory = saveFactory;
        this.p = new Player(startingLocation); // could also add p as a parameter and set it equal to 'p' here. then would have to put '@Component' on the Player class so Spring could generate one for us...rather than making a new instance of Player here)
        //have to set Command = this.Commands so we can reference Commands outside of this scope (outside curly braces)
        //start time not in this because we want to wait to start the clock once the game is actually RUN...not when the object is initiated.
        //exit time not in this cuz not applicable, cant set the end time at the beginning.
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void run() {
        this.setStartTime(new Date());

        boolean loop = true;
        while (loop) {
            try {
                io.displayPrompt("> ");
                String input = io.receiveInput();
                Command validCommand = getValidCommand(input);
                if (null != validCommand) {
                    validCommand.execute(input, this); //passing Game instance as parameter for execute because it needs input AND Game instance in order to run
                } else {
                    io.displayText("Huh? I don't understand.");
                }
            } catch (GameExitException gee) {
                loop = false;
            }
        }
        this.setEndTime(new Date());

        }

        private Command getValidCommand (String input) {
            return Stream.of(Commands).filter(command -> command.isValid(input, this)).findFirst().orElse(null);
            //this filters through all commands and runs isValid method. If command is valid then it finds first command and returns it.
            // If the command is NOT valid then it returns null

            // ^^^ STREAM version of for each loop below

                    //for (Command command : Commands) {
               // if (command.isValid(input, this)) {
                    //return command;
               // }
            //}
           //return null;
        }

    public Location getLocationOf (String intendedLocationName){
        for (Location location : locationList) {//for each Location in the list we just created
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {//check to see if intendedLocationName we passes in equals the name of the location
                return location;//return the actual Location "tdh" to whatever called getLocationOf)
            }
        }
        return null;
    }


    }
