package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command {
    private InputOutput io;

    public AttackCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        input = input.trim();
        if (input == null) return false;
        if (input.equalsIgnoreCase("attack")) {
            return true;
        } else return false;
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        if (game.getPlayer().getLocation().getAdversary() == null) {
            io.displayText("Attack what? You idiot.");
        } else {
            Random r = new Random();
            int num = r.nextInt(100) + 1;
            io.displayText(String.valueOf(num));
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
    //@Override
    //public int random() {
      //  Random r = new Random();
        //int num = r.nextInt(100) + 1;
        //return num;
}
