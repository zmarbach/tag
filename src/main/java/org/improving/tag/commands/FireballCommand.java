package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SwingCommand extends BaseAliasedCommand {
    private InputOutput io;
    private static int swingCount = 0;

    public SwingCommand(InputOutput io, String... aliases) {
        super(io, "s", "swing");
        this.io = io;
    }

    @Override
    public void childExecute(String input, Game game) {
        if (game.getPlayer().getLocation().getAdversary() == null) {
            io.displayText("What do you want to swing at? There is nobody here.");
            return;
        } else {
            swingCount++;
            if (swingCount < 6) {
                Random r = new Random();
                int num = r.nextInt(100) + 1;
                if (num <= 5) {
                    var a = game.getPlayer().getLocation().getAdversary();
                    a.setHitPoints(0);
                    var advItem = game.getPlayer().getLocation().getAdversary().getItem();
                    game.getPlayer().getInventory().addItem(advItem);
                    game.getPlayer().getLocation().getAdversary().setItem(UniqueItems.NOTHING);
                    io.displayText("Attack was massively effective! You have killed " + a.getName() + " and stolen " + advItem);
                    game.getPlayer().getLocation().setAdversary(null);
                } else {
                    io.displayText("Swing missed. You only get 5 swings/game. You have " + String.valueOf(5-swingCount) + " swings left.");
                }
            } else {
                io.displayText("Sorry. You can only use swing 5 times per game. Should have made them count.");
            }
        }
    }
}
