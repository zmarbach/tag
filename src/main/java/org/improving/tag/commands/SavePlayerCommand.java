package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.Player;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Component
public class SavePlayerCommand extends BaseAliasedCommand implements Serializable {
    public SavePlayerCommand(InputOutput io, String... aliases) {
        super(io, "sp", "save player");
    }

    @Override
    public void childExecute(String input, Game game) throws IOException {
        FileOutputStream fileStream = new FileOutputStream("Desktop");
        ObjectOutputStream os = new ObjectOutputStream(fileStream);
        Player playerObj = game.getPlayer();
        os.writeObject(playerObj);
        os.close();
        io.displayText("serialization complete");
    }
}
