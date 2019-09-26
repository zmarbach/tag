package org.improving.tag;

import org.springframework.stereotype.Component;

@Component
public class Adversary {
    private String name;
    private int hitPoints;//set this your self
    private int damageTaken;
    private int attackDamage;//add 10 dammage every time your attack lands

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
        hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        attackDamage = attackDamage;
    }
}
