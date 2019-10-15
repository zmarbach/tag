package org.improving.tag;

import org.improving.tag.database.ExitDAO;
import org.improving.tag.database.LocationDAO;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldBuilder {
    private List<Location> locationList = new ArrayList<>();
    private LocationDAO locationDAO;
    private ExitDAO exitDAO;

    public WorldBuilder(LocationDAO locationDAO, ExitDAO exitDAO) {
        this.locationDAO = locationDAO;
        this.exitDAO = exitDAO;
    }

    public Location buildWorld() {
        try {
            List<Location> locations = locationDAO.findAll();
            for (Location location : locations) {
                List<Exit> exits = exitDAO.findExitsByOriginId(location.getId());
                exits.forEach(exit -> {
                    Location destination = locations.stream().filter(loc -> loc.getId() == exit.getDestinationId()).findFirst().orElseThrow();
                    exit.setDestination(destination);
                    location.getExits().add(exit);
                });
            }
            locationList = locations;
            return locationList.get(2);
        } catch (Exception e){
            e.printStackTrace();
            return buildHardCodedWorld();
        }
    }

    public Location buildHardCodedWorld () {
        var tdh = new Location();
        tdh.setName("The Deathly Hallows");
        this.locationList.add(tdh);//add each location to the list of locations, so we can use this list of locations to cross check against
        var adv2 = new Adversary();
        adv2.setName("Bowser");
        adv2.setHitPoints(20);
        adv2.setDamageTaken(0);
        tdh.setAdversary(adv2);
        adv2.setItem(UniqueItems.BLUE_SHELL);

        var td = new Location();
        td.setName("The Dessert");
        this.locationList.add(td);

        var ta = new Location();
        ta.setName("The Amazon");
        this.locationList.add(ta);

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese Shop");
        this.locationList.add(tmcs);
        tmcs.setTreasureChest(new TreasureChest(UniqueItems.THE_ONE_RING, "A Kraft box"));

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
        var adv1 = new Adversary();
        adv1.setName("Sauron");
        adv1.setHitPoints(100);
        adv1.setDamageTaken(0);
        md.setAdversary(adv1);

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

    public List<Location> getLocationList() {
        return locationList;
    }

}
