package org.improving.tag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity(name = "exits")
public class Exit {

    @Id
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToOne
    @JoinColumn(name = "DestinationId")
    private Location destination;

    //    @Column(name = "DestinationId")
    //    private int destinationId;

    @ManyToOne
    @JoinColumn(name = "OriginId")
    private Location origin;

    @Transient
    private List<String> aliases = new ArrayList<String>();

    @Column(name = "Aliases")
    private String aliasesDb;


    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getAliasesDb() {
        return aliasesDb;
    }

    public void setAliasesDb(String aliasesDb) {
        this.aliasesDb = aliasesDb;
    }

    public Exit() {
    }//add this so we can use a totally empty constructor for tests and stuff

    public Exit(String name, Location destination, String... aliases) {///"..." has to be the last parameter
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));//take all of the "aliases" we pass and add them to the alias list for this instance of Exit (aliases above)
    }

//    public int getDestinationId() {
//        return destinationId;
//    }
//
//    public void setDestinationId(int destinationId) {
//        this.destinationId = destinationId;
//    }

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @PostLoad
    public void postLoad() {
        String[] allAliases = aliasesDb.trim().replace(" ", "").split(",");
        for(String alias : allAliases) {
            aliases.add(alias);
        }
    }


}
