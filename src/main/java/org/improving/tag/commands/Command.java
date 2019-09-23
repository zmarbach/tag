package org.improving.tag.commands;

import org.improving.tag.Game;

public interface Command {
    boolean isValid(String input, Game game);
    // Player lives in GAME (because we created a new instance there).
    // WE WANT TO BE ABLE TO SEE PLAYER WHEN RUNNING THESE METHODS because we want to eventually SET the player name, hitPoints, etc
    // (commands might change based on what player you are)
    // So, since Player lives in GAME, we have to pass an instance of GAME and require as a parameter.
    void execute(String input, Game game);
}
