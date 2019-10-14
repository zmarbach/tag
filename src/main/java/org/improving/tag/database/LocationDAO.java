package org.improving.tag.database;

import org.improving.tag.Adversary;
import org.improving.tag.Location;
import org.improving.tag.items.UniqueItems;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Component
public class LocationDAO {
    private final JdbcTemplate jdbcTemplate;

    public LocationDAO (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Location> findAll() {
        try {
            List<Location> locations = jdbcTemplate.query(
                    //have to specify all these cuz otherwise there are 2 "Name" columns and SQL doesn't know which one you are referring to
                    "SELECT l.Id as LocId, l.Name as LocName, l.Description, l.AdversaryId, a.Id as AdvId, a.Name as AdvName, a.HitPoints," +
                            " a.DamageTaken, a.AttackDamage, a.DropItem FROM location l LEFT JOIN adversary a ON l.AdversaryId = a.Id",
                    (result, rowNum) -> {
                        Location location = new Location();
                        location.setId(result.getInt("LocId"));
                        location.setName(result.getString("LocName"));
                        location.setDescription(result.getString("Description"));

                        if (result.getString("AdversaryId") != null) {
                            EntityManager em = JPAUtility.getEntityManager();
                            Adversary adversary = em.find(Adversary.class, Long.parseLong(result.getString("AdversaryId"))); //use EntityManager to find an advversary with that Id

                                //Adversary adversary = new Adversary();
                                //adversary.setName(result.getString("AdvName"));
                                //adversary.setHitPoints(result.getInt("HitPoints"));
                                //adversary.setDamageTaken(result.getInt("DamageTaken"));
                                //String dropItem = result.getString("DropItem");

                                    location.setAdversary(adversary); //actually PUT the adversary at the location
                                    System.out.println("Set adversary to: " + adversary.getName());
                            }
                            return location;
            });
        return locations;
        }
        catch (DataAccessException e){
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }

}
