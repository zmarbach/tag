package org.improving.tag;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name = "";
    private String description = "";
    private List<String> tags = new ArrayList<String>();
    ///have to initialize this as soon as we create the class (even if it has nothing in it) otherwise the value is NULL and we will get null pointer exception when we try to run method off of it
    private List<Exit> exits = new ArrayList<Exit>();

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

    //public void setExits(List<Exit> exits) {
      //  this.exits = exits;
    //}


}

