package org.improving.tag;

import org.improving.tag.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name = "";
    private String description = "";
    private List<String> tags = new ArrayList<String>();
    ///have to initialize this as soon as we create the class (even if it has nothing in it) otherwise the value is NULL and we will get null pointer exception when we try to run method off of it
    private List<Exit> exits = new ArrayList<Exit>();
    private Adversary adversary;
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;//each location will have this treasure chest as default (set method will override this)

    public Adversary getAdversary() {
        return adversary;
    }

    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    //public void setTags(List<String> tags) {///this is setting the ENTIRE LIST...we want to make someone add and remove the items in the list, not the WHOLE thing.
    //this.tags = tags;
    //}

    public List<Exit> getExits() {
        return exits;
    }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }

    public TreasureChest getTreasureChest(){
        return treasureChest;
    }

    public Item openTreasureChest() {
        //do this here so we can destroy the treasure chest after it has been opened. Have to do this at the Location level, cannot do it from within the treasure chest itself
        if (TreasureChest.NO_TREASURE.equals(treasureChest)) {
            throw new UnsupportedOperationException();
        }
            Item treasureItem = treasureChest.getItem();
            treasureChest = TreasureChest.NO_TREASURE;//getting rid of the treasure chest. Could also do this with simple setter after getting the item
            return treasureItem;
        }
    }
