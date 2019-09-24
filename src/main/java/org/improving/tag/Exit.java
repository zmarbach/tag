package org.improving.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exit {
    private String name;
    private Location destination;
    private List<String> aliases = new ArrayList<String>();

    public Exit() {}//add this so we can use a totally empty contructor for tests and stuff

    public Exit(String name, Location destination, String...aliases) {///"..." has to be the last parameter
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));//take all of the "aliases" we pass and add them to the alias list for this instance of Exit (aliases above)
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    //public void setAliases(List<String> aliases) {
      //  this.aliases = aliases;
    //} REMOVE because it is a List of arrays and we dont want someone to be able to set the ENTIRE LIST
}
