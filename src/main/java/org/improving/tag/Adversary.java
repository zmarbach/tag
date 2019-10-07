package org.improving.tag;

import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Adversary implements Serializable {
    private String name;
    private int hitPoints;
    private int damageTaken;
    private int attackDamage;//assuming this is how powerful each attack is from the adversary;
    private Item item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
