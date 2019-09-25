package org.improving.tag;

public class Player {
    private String name = "The Player";
    private int hitPoints = 100;
    private Location location;

    public Player(Location location) {
        this.location = location;//Player needs to be initialized to show FIRST LOCATION but want GAME responsible for setting the location,
        // so make constructor for Player that requires we pass it a Location as parameter and then pass the startingLocation when we create a player in Game
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {return hitPoints;}

    public void setHitPoints(int hitPoints) {this.hitPoints = hitPoints;}
}
