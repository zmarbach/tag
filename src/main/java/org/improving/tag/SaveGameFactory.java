package org.improving.tag;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SaveGameFactory {
    private final FileSystemAdapter fsa;//need to create different class to interact with file system. SaveGame will NEED an instance of FSA in order to work
    private final InputOutput io;//need to give SaveGameFactory the ability to tell user there is an error if necessary when trying to save the game

    public SaveGameFactory(FileSystemAdapter fsa, InputOutput io) { //SaveGameFactory requires a FileSystemAdapter as parameter...need an instance of FSA to make this work
        this.fsa = fsa;
        this.io = io;
    }


    public String save(Game game) { //create file and then store location name in that file and give us the filepath
        var locationName = game.getPlayer().getLocation().getName();
        Map<String, String> saveContents = new HashMap<>(); //dictionary stores the "key" and "value" associated with the key
        saveContents.put("location", locationName); //create key and make it link to locationName (which we get from methods called above)


        String path = null;//need to set it to null, so that if you get get stuck in the catch, it will be able to return something
        try {
            path = fsa.saveToFile(saveContents); //tell FSA to save our contents (variable saveContents defined above...which is a Dictionary) to a file,
            // then return the file path (a String variable called path...it says var here, but saveToFile method on FSA returns a String)
            io.displayText("Saved : " + path);
        } catch( IOException ex) {
            io.displayText(ex.toString());//print out the execption in string form out to the users screen if there is an error
        }

        return path;
    }

    public void load(String path, Game g) {
        Map<String,String> saveContents;//put this out here so we can use it in the lines outside of the try/catch block

        try {// loadFile gave us a notification that it might throw and excpetion, click alt Enter and surround it with a try/catch
            saveContents = fsa.loadFile(path); //we put a map in, so expecting to get a map back out when we load
        } catch (IOException ex) {
            io.displayText(ex.toString());
            io.displayText("Failed to load file.");
            return;//get out, nothing was changed
        }
        Location lastKnownLocation = g.getLocationOf(saveContents.get("location"));//get the VALUE associated with the key called "location" on saveContents Hashmap, give it to getLocationOf method on Game, which will return the ACTUAL location, not just the location name ("tdh" NOT "The Deathly Hallows")
        g.getPlayer().setLocation(lastKnownLocation);//then set the players actual location ("tdh" to lastKnownLocation (where they were when we saved it)

    }
}
