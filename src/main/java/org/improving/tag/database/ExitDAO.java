//package org.improving.tag.database;
//
//import org.improving.tag.Exit;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import java.util.List;
////
////@Component
////public class ExitDAO {
////    private final JdbcTemplate jdbcTemplate;
////
////    public ExitDAO (JdbcTemplate jdbcTemplate) {
////        this.jdbcTemplate = jdbcTemplate;
////    }
//    //public List<Exit> findExitsByOriginId() {
////        try {
//            //List<Exit> exits = jdbcTemplate.query("SELECT * FROM exits WHERE OriginId = " + Id,
//              //      (result, rowNum) -> {
//                        //EntityManager em = JPAUtility.getEntityManager();
//                        //List<Exit> exits = em.createQuery("SELECT exits FROM org.improving.tag.Exit exits").getResultList();
//                        //Exit exit = em.find(Exit.class, exit.getDestination();
//
//                        //Exit exit = new Exit();
//                        //exit.setName(result.getString("Name"));
//                        //exit.setDestinationId(result.getInt("DestinationId"));
//
////                        String aliasString = result.getString("Aliases");
////                        if (null != aliasString) {
////                            String[] aliases = aliasString.trim().replaceAll(" ", "").split(",");
////                            List<String> listOfAliases = Arrays.asList(aliasString);
////                            for (String alias : listOfAliases) {
////                                exit.getAliases().add(alias);
////                            }
////                        } return exit;
////                    });
////            return exits;
////        }
////        catch (DataAccessException e){
////            System.out.println("Exception in JDBC: " + e.getMessage());
////            return null;
////        }
////    }
//}
