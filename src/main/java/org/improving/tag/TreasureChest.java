package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import java.io.Serializable;

public class TreasureChest  implements Serializable {
    public static final TreasureChest NO_TREASURE = new TreasureChest(UniqueItems.NOTHING, ""); //create new treasureChest with nothing in it and set as default treasurechest for all locations
    private final Item item;//it is final so HAVE to initialize it...do this in the constructor below
    private final String description;

    public TreasureChest(Item item, String description) {
        this.item = item;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {//added this to demonstrate toString. If comment this out then we are using Objects toString() method, which will return the actual Object's location in memory...not the string itself
        return description;
    }
}
