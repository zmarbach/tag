package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Scanner;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] Commands;
    private InputOutput io;
    private Player p;


    public Game(Command[] Commands, InputOutput io) {
        this.Commands = Commands;
        this.io = io;
        this.p = new Player(); // could also add p as a parameter and set it equal to 'p' here. then would have to put '@Component' on the Player class so Spring could generate one for us...rather than making a new instance of Player here)
        //have to set Command = this.Commands so we can reference Commands outside of this scope (outside curly braces)
        //start time not in this because we want to wait to start the clock once the game is actually RUN...not when the object is initiated.
        //exit time not in this cuz not applicable, cant set the end time at the beginning.
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
            io.displayPrompt("> ");
            String input = io.receiveInput();

            Command validCommand = getValidCommand(input);
            if (null != validCommand) {
                validCommand.execute(input, this); //passing Game instance as parameter for execute because it needs input AND Game instance in order to run
            } else if (input.equalsIgnoreCase("exit")) {
                io.displayText("Goodbye.");
                loop = false;
            } else {
                io.displayText("Huh? I don't understand.");
            }
        }
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        Command validCommand = null;
        for (Command command : Commands) {
            if (command.isValid(input, this)) {
                return command; //Assume the user types 'jump'. This method runs and asks DanceCommand, is this a valid command for you? No.
                // Ok asks demo command, is this valid for you? No. (Tim example - "but type a dot")
                // Jump is this valid for you? Yes...run execute!
            }
        }
        return null;
    }
}
