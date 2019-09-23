package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component//this tells Spring that is should register this as a Command and pass it to Game
// construcotr when it creates list of commands for the game
public class DemoCommand implements Command {
    private final InputOutput io;//final says that once constructor is completed, then we cannot change io
    private Integer ingCount = 0;

    public DemoCommand(InputOutput io) {
        this.io = io; //but can change io WITHIN a contructor
        //must pass something that implements InputOutput interface (ex: ConsoleInputOutput which has the displayText method, that we call below.)

    }

    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().endsWith("ing");

    }

    @Override
    public void execute(String input, Game game) {
        ingCount = ingCount + 1;
        io.displayText("We have 'ing'ed " + ingCount + " times.");
    }
}
