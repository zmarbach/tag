package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.Arrays;

@Entity(name = "adversary")
public class Adversary {
    @Id
    Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "HitPoints")
    private int hitPoints;

    @Column(name = "DamageTaken")
    private int damageTaken;

    @Column(name = "AttackDamage")
    private int attackDamage;//assuming this is how powerful each attack is from the adversary;

    @Transient
    private Item item = UniqueItems.NOTHING;

    @Column(name = "DropItem")
    private String dropItemDb;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDropItemDb() {
        return dropItemDb;
    }

    public void setDropItemDb(String dropItemDb) {
        this.dropItemDb = dropItemDb;
    }

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

    @PostLoad
    public void postLoad() {
        if (null != dropItemDb) {
            this.setItem(Arrays //actually SET the item on the adversary (based on what it says in SQL database)
                    .stream(UniqueItems.values())
                    .filter(item -> item.getName().equals(dropItemDb))
                    .findFirst()
                    .orElse(null));
        }
    }
}
