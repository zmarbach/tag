package org.improving.tag.items;

public enum UniqueItems implements Item {
    THE_ONE_RING("a golden ring!"), BLUE_SHELL("a blue shell with wings!"), NOTHING("");
    // ^^^ this is same thing as --- public static final UniqueItem THE_ONE_RING = new UniqueItem("a golden ring") --- that is just how you must write it for enums
    private String description;

    UniqueItems(String description) {
        this.description = description;
    }
    //public String getDescription(){
      //  return description;
    //}//// took this out to demonstrate how toString works even w/o calling the method specifically on OPEN command

    @Override
    public String toString() {
        return description;
    }
}
