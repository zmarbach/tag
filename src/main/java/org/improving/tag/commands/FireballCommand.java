package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FireballCommand extends BaseAliasedCommand {
    private InputOutput io;
    private int fbCount = 0;

    public FireballCommand(InputOutput io, String... aliases) {
        super(io, "f", "fb", "fireball", "use fireball");
        this.io = io;
    }

    @Override
    public void childExecute(String input, Game game) {
        if (game.getPlayer().getLocation().getAdversary() == null) {
            io.displayText("There is nobody there. Do you want to waste a perfectly good fireball?");
            return;
        } else {
            fbCount++;
            if (fbCount < 6) {
                Random r = new Random();
                int num = r.nextInt(100) + 1;
                if (num >=1 ) {
                    var a = game.getPlayer().getLocation().getAdversary();
                    a.setHitPoints(0);
                    var advItem = game.getPlayer().getLocation().getAdversary().getItem();
                    game.getPlayer().getInventory().addItem(advItem);
                    game.getPlayer().getLocation().getAdversary().setItem(UniqueItems.NOTHING);
                    io.displayText("Fireball was massively effective! " + a.getName() + " was consumed by flames and you stole " + advItem);
                    game.getPlayer().getLocation().setAdversary(null);
                } else {
                    io.displayText("Fireball missed. You only get 5 fireballs/game. You have " + String.valueOf(5-fbCount) + " fireballs left.");
                }
            } else {
                io.displayText("Sorry, no more fireballs. You should have made them count.");
            }
        }
    }
}
