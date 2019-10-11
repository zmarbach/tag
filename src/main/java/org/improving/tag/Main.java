package org.improving.tag;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringContext.class);

        Game game = context.getBean(Game.class);
        game.run();
        //getBean is the Spring version of new...Spring make me a NEW GAME
        //this means we don't have to create NEW Interfaces (and its Implementors) and SuperClasses (and its subclasses) and put them all in the right order here
        //wont find Tests in this cuz not @Component. (or Location, Exit because not required as parameters to create Game)
        //also wont find Player because no @Component (because we create new Player in the constructor of Game...so it is included in Spring scan of Game)

        // game = run the get.Bean method of context (defined above) and hand it Game.class
        //it wil run configure everything using SpringContext and run the game.

        long elapsedTicks = game.getEndTime().getTime() -
                game.getStartTime().getTime();
        double elapsedSeconds = elapsedTicks / 1000.0;
        System.out.println("We were running for " + elapsedSeconds + "s.");
    }
}