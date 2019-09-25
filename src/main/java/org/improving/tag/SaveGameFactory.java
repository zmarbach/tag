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
}
