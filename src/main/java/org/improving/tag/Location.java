package org.improving.tag;

import org.improving.tag.items.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "location")
public class Location {

    @Id
    private Long id;

    @Column(name = "Name")
    private String name = "";

    @Column(name = "Description")
    private String description = "";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "origin")
    private List<Exit> exits = new ArrayList<Exit>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AdversaryId")
    private Adversary adversary;

    //@Column(name = "AdversaryId")
    //private Long AdversaryIdDb;

    @Transient
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;//each location will have this treasure chest as default (set method will override this)



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adversary getAdversary() {
        return adversary;
    }

    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }

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

    public List<Exit> getExits() {
        return exits;
    }

    public void setExits(List<Exit> exits) {
        this.exits = exits;
    }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }

    public TreasureChest getTreasureChest(){
        return treasureChest;
    }

    public Item openTreasureChest() {
        //do this here so we can destroy the treasure chest after it has been opened. Have to do this at the Location level, cannot do it from within the treasure chest itself
        if (TreasureChest.NO_TREASURE.equals(treasureChest)) {
            throw new UnsupportedOperationException();
        }
            Item treasureItem = treasureChest.getItem();
            treasureChest = TreasureChest.NO_TREASURE;//getting rid of the treasure chest. Could also do this with simple setter after getting the item
            return treasureItem;
        }
    /*public Long getAdversaryIdDb() {
        return AdversaryIdDb;
    }

    public void setAdversaryIdDb(Long adversaryIdDb) {
        AdversaryIdDb = adversaryIdDb;
    }*/

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Location) {
                Location loc = (Location) obj;
                return this.getName().equals(loc.getName()) && this.getDescription().equals(loc.getDescription());
            }
            return super.equals(obj);
        }
    }
