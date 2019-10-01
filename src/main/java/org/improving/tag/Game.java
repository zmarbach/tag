package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] Commands; //Spring creates this array of all our commands. It scans for '@Component' and if that class implements Command, then Spring puts that class into the Commands[];
    private InputOutput io;
    private Player p;
    private List<Location> locationList = new ArrayList<>();
    private Location startingLocation;
    private final SaveGameFactory saveFactory;


    public Game(Command[] Commands, InputOutput io, SaveGameFactory saveFactory) throws RuntimeException {
        startingLocation = buildWorld();
        this.Commands = Commands;
        this.io = io;
        this.saveFactory = saveFactory;
        this.p = new Player(startingLocation); // could also add p as a parameter and set it equal to 'p' here. then would have to put '@Component' on the Player class so Spring could generate one for us...rather than making a new instance of Player here)
        //have to set Command = this.Commands so we can reference Commands outside of this scope (outside curly braces)
        //start time not in this because we want to wait to start the clock once the game is actually RUN...not when the object is initiated.
        //exit time not in this cuz not applicable, cant set the end time at the beginning.
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void run() {
        this.setStartTime(new Date());

        boolean loop = true;
        while (loop) {
            try {
                io.displayPrompt("> ");
                String input = io.receiveInput();
                Command validCommand = getValidCommand(input);
                if (null != validCommand) {
                    validCommand.execute(input, this); //passing Game instance as parameter for execute because it needs input AND Game instance in order to run
                } else {
                    io.displayText("Huh? I don't understand.");
                }
            } catch (GameExitException gee) {
                loop = false;
            }
        }
        this.setEndTime(new Date());
        }

        private Command getValidCommand (String input){
            Command validCommand = null;
            for (Command command : Commands) {
                if (command.isValid(input, this)) {
                    return command;
                }
            }
            return null;
        }

        private Location buildWorld () {//private because we dont want anyone else to build a world
            var tdh = new Location();
            tdh.setName("The Deathly Hallows");
            this.locationList.add(tdh);//add each location to the list of locations, so we can use this list of locations to cross check against

            var td = new Location();
            td.setName("The Dessert");
            this.locationList.add(td);

            var ta = new Location();
            ta.setName("The Amazon");
            this.locationList.add(ta);

            var tmcs = new Location();
            tmcs.setName("The Mac & Cheese Shop");
            this.locationList.add(tmcs);

            var tvm = new Location();
            tvm.setName("The Velvet Moose");
            this.locationList.add(tvm);

            var a = new Location();
            a.setName("Airport");
            this.locationList.add(a);

            var tr = new Location();
            tr.setName("The Reef");
            this.locationList.add(tr);

            var tm = new Location();
            tm.setName("The Mountains");
            this.locationList.add(tm);

            var tict = new Location();
            tict.setName("The Ice Cream Truck");
            this.locationList.add(tict);

            var mall = new Location();
            mall.setName("The Mall");
            this.locationList.add(mall);

            var md = new Location();
            md.setName("Mount Doom");
            this.locationList.add(md);
            var adv = new Adversary();
            adv.setName("Sauron");
            md.setAdversary(adv);

            var tvod = new Location();
            tvod.setName("The Volcano of Death");
            this.locationList.add(tvod);

            //create new exits and pass name, destination, and aliases...because these are parameters in the Exit constructor!!!
            tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));///case doesnt matter cuz we will igNorecase
            tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "brownie", "deathly", "the"));
            td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
            td.getExits().add(new Exit("Rocky Road", tict, "road", "rocky", "rr"));
            td.getExits().add(new Exit("The Dock", a, "dock"));
            ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "amazing", "moose", "amaz-ing"));
            tmcs.getExits().add(new Exit("Highway 121", ta, "121", "hwy 121", "h121"));
            tmcs.getExits().add(new Exit("Paradise Rd", tr, "paradise", "rd", "paradise road"));
            tmcs.getExits().add(new Exit("Highway 21", tvod, "21", "hwy 21", "h21"));
            tvm.getExits().add(new Exit("The Pudding Slide", a, "pudding", "pudding slide", "slide", "ps"));
            tvm.getExits().add(new Exit("The Front Door", ta, "front", "door", "fd", "front door"));
            a.getExits().add(new Exit("flight 121", tm, "121", "f 121"));
            a.getExits().add(new Exit("Flight to the Mall", mall, "to the Mall", "mall"));
            tr.getExits().add(new Exit("the city walk", mall, "city walk", "city", "walk", "cw"));
            tr.getExits().add(new Exit("The Scenic Route", tvm, "scenic route", "scenic", "route"));
            tm.getExits().add(new Exit("the plane", ta, "plane", "tp"));
            tm.getExits().add(new Exit("bike trail", tr, "bike", "bt"));
            tm.getExits().add(new Exit("The narrow trail", md, "narrow", "tnt"));
            tm.getExits().add(new Exit("The Lava Flow", tvod, "lava flow", "lava", "flow"));
            tict.getExits().add(new Exit("Magic Portal", md, "magic portal", "magic", "portal"));
            mall.getExits().add(new Exit("Path to Doom", md, "path", "pd"));
            mall.getExits().add(new Exit("An escalator of doom", tvod, "escalator", "escalator pof doom"));
            md.getExits().add(new Exit("The Cab", mall, "cab"));
            md.getExits().add(new Exit("Jump into Lava", tvod, "jump lava", "lava", "jump"));


            return tdh;
        }

        public Location getLocationOf (String intendedLocationName){
            for (Location location : locationList) {//for each Location in the list we just created
                if (intendedLocationName.equalsIgnoreCase(location.getName())) {//check to see if intendedLocationName we passes in equals the name of the location
                    return location;//return the actual Location "tdh" to whatever called getLocationOf)
                }
            }
            return null;
        }
    }
