package org.improving.tag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Exit implements Serializable {
    private String name;
    private Location destination;
    private List<String> aliases = new ArrayList<String>();

    public Exit() {
    }//add this so we can use a totally empty constructor for tests and stuff

    public Exit(String name, Location destination, String... aliases) {///"..." has to be the last parameter
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

    @Override
    public String toString() {//when call toString, it will in turn call getName method below, which returns a string of the exit name
        return this.getName();
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {//will only enter this iff block IF the object is an instance of an Exit
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) && this.getDestination().equals(exit.getDestination());
        }
        return super.equals(obj);
    }
}
