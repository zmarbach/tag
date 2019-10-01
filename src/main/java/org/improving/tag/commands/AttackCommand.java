package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand extends BaseAliasedCommand implements Command {
    private InputOutput io;

    public AttackCommand(InputOutput io) {
        super(io,"a", "att", "attack");
        this.io = io;
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        if (game.getPlayer().getLocation().getAdversary() == null) {
            io.displayText("Attack what? You idiot.");
            return;
        }
            Random r = new Random();
            int num = r.nextInt(100) + 1;
            if (num <= 20) {
                var damagePerAttack = 10;
                var a = game.getPlayer().getLocation().getAdversary();
                var currentDamageTaken = a.getDamageTaken();
                var currentHitPoints = a.getHitPoints();
                a.setDamageTaken(currentDamageTaken + damagePerAttack);
                a.setHitPoints(currentHitPoints - damagePerAttack);
                io.displayText("Attack was very effective! " + a.getName() + " took " + damagePerAttack + " damage.");
                io.displayText(a.getName() + "'s remaining HP : " + a.getHitPoints());

            } else {
                io.displayText("Attack has missed. You have terrible aim!");
            }
        }
    }
