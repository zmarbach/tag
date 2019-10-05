package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {
        String displayString = "You have these items:";
        return items.stream().sorted(new ItemComparator()).map(item -> "\n" + item).reduce(displayString, (answer, itemName) -> answer += itemName);
        // start with display string, then check each item in the list and add the itemName to the end of the answer
        //keep doing this for all items and you end up with a final answer that has the displayString and all the item names below it

        //Stream above is the same as below...
            // items.sort(new ItemComparator());//this puts things in alpha order
            //for (Item item : items) {
            //   displayString += "\n" + item; // '+=' same thing as displayString = displayString + "\n" + item
            //}
    }
}


