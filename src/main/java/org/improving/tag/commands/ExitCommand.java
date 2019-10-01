package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends BaseAliasedCommand {
    private final SaveGameFactory saveFactory;

    public ExitCommand (InputOutput io, SaveGameFactory saveFactory) {
        super(io,"exit", "e");
         this.saveFactory = saveFactory;
    }

    @Override
    public void childExecute(String input, Game game) {
        saveFactory.save(game);
        io.displayText("Goodbye."); //do not need io as class level variable because it is marked as PROTECTED in BaseAliasedCommand (which means any subclasses and any classes in same package can access it)
        throw new GameExitException();
    }
}
