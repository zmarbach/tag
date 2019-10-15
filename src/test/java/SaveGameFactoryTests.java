import org.improving.tag.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SaveGameFactoryTests {

    private TestInputOutput io;
    private FileSystemAdapter fsa;
    private SaveGameFactory target;
    private Game g;
    private MovementStore ms;

    @BeforeEach
    public void setup() {//instantiating variables before each test method
        io = new TestInputOutput();
        fsa = mock(FileSystemAdapter.class); // create mock version of FileSystemAdapter for testing purposes instead of create interface, although we will create an interface for FileSystemAdapter in future because will want to let other classes implement FSA
        target = new SaveGameFactory(fsa, io, ms);
        g = new Game(null, io, target, new WorldBuilder(null));//had to create variables above to pass them as parameters
    }

    /*@Test
    public void save_should_preserve_location_name() throws IOException {//this test might throw an exception, but it wont actually because we are using MOCK fsa in the test
        //arrange

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
    }*/

    @Test
    public void load_should_load_save_file() throws IOException {
        //Arrange
        String path = "this is a fake path";

        when(fsa.loadFile(path)).thenReturn(Map.of("location", "The Amazon"));//when we call loadFile and give it a path, then return map of the key and value

        //Act
        target.load(path, g); //need to pass Game when calling load method, because we expect to get the location of the player out of it, and we get the location from GAME)

        //Assert (after done loading, I expect the location to be "The Amazon"
        assertEquals("The Amazon", g.getPlayer().getLocation().getName());


    }
}
