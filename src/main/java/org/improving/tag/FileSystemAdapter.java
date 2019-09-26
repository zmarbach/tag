package org.improving.tag;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;// acknowledges this could result in an exception
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FileSystemAdapter {
    public String saveToFile(Map<String, String> contents) throws IOException {
        var file = File.createTempFile("saveGame", "");//create new temp file


        //this is called Try With Resources. it will CLOSE the file after the loop, which will ACTUALLY save the contents to the FILE.
        //version of the try, catch, finally
        try (var writer = new FileWriter(file)) {//create new FileWriter and give it the temp file
            for (var pair : contents.entrySet()) {//have FileWriter look through all pairs of keys and values in the Hashmap (variable called contents above)
                writer.append(pair.getKey() + "|" + pair.getValue());//for every pair in the temp file, write the key and value to the file
            }
        }

        return file.getAbsolutePath();//return a string to the SaveGameFactory, the string will be the filepath of the file we put saveContents in
    }

    public Map<String, String> loadFile(String path) throws IOException {//hand it a path and get back a Map
        Map<String, String> properties = new HashMap<>();//create new hashmap to put things in
        List<String> contents = Files.readAllLines(Path.of(path));   //read all the lines in the file we give it and return a list of strings
        for (String line : contents) {//for every line in the file, run this loop
            String[] temp = line.split("\\|"); //split on | and put the strings into an array called temp
            properties.put(temp[0], temp[1]); //put each string from the split in the Hashmap (as key and value) that we created above (called properties)
        }
        return properties;
    }
}
