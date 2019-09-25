import org.improving.tag.FileSystemAdapter;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SaveGameFactoryTests {
    @Test
    public void save_should_preserve_location_name() throws IOException {//this test might throw an exception, but it wont actually because we are using MOCK fsa in the test
        //arrange
        TestInputOutput io = new TestInputOutput();
        FileSystemAdapter fsa = mock(FileSystemAdapter.class); // create mock version of FileSystemAdapter for testing purposes instead of create interface,
        // although we will create an interface for FileSystemAdapter in future because will want to let other classes implement FSA
        SaveGameFactory target = new SaveGameFactory(fsa, io);
        Game g = new Game(null, io, target);//had to create variables above to pass them as parameters

        //all of this Tim had to Google...when saveToFIle is called, capture a copy of the contents cuz I want to check the contents in the asserts below
        Class<Map<String, String>> dictClass = (Class<Map<String, String>>)(Class)Map.class;
        ArgumentCaptor<Map<String, String>> contentsCaptor = ArgumentCaptor.forClass(dictClass);
        when(fsa.saveToFile(any())).thenReturn("this is dumb");

        //act
        String path = target.save(g); //computer will save game to a file path...we want to get that file path

        //assert
        verify(fsa).saveToFile(contentsCaptor.capture());
        var loc = contentsCaptor.getValue().get("location");//give me the contents of what was saved from contentsCaptor
        assertEquals("The Deathly Hallows", loc);//check to see if it equals "The Deathly Hallows"
        assertNotNull(path); //the path we get from save method cannot be null
        assertNotEquals("", path); ///the path we get from save method cannot be and empty string
    }
}
