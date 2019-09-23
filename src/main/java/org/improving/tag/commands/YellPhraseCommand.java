package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class YellPhraseCommand implements Command {
    private InputOutput io;

    public YellPhraseCommand (InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input) {
        if (input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("yell");
        }

    @Override
    public void execute(String input) {
        input = input.trim();
        var phrase = input.substring(5);
        io.displayText("You yell " + phrase + "!!!");
    }
}
