package org.improving.tag.items;

public enum UniqueItems implements Item {
    THE_ONE_RING("The One Ring", "a golden ring"),
    BLUE_SHELL("Blue Shell","a blue shell with wings"),
    EGGO_WAFFLE("Eggo Waffle","part of a balanced breakfast"),
    UNFORGETTABLE_MUSHROOM ("Unforgettable Mushroom","an edible toad"),
    EVERLASTING_GOBSTOPPER ("Everlasting Gobstopper","a nice piece of candy"),
    NOTHING("","");
    // ^^^ this is same thing as --- public static final UniqueItem THE_ONE_RING = new UniqueItem("a golden ring") --- that is just how you must write it for enums
    private final String name;
    private final String description;

    UniqueItems(String name, String description) {
        this.name = name;
        this.description = description;
    }
    //public String getDescription(){
      //  return description;
    //}//// took this out to demonstrate how toString works even w/o calling the method specifically on OPEN command

    @Override
    public String toString() {
        return name + ": " + description;
    }

    @Override
    public String getName() {
        return name;
    }
}
