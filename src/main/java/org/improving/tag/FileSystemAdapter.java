package org.improving.tag;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;// acknowledges this could result in an exception
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
}
