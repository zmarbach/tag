import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExitTests {

    @Test
    public void to_String_should_include_name() {
        //arrange
        var testObj = new Exit("Door", new Location());

        //act
        var result = testObj.toString();

        //assert
        assertTrue(result.contains("Door"));
    }

    @Test
    public void equals_should_be_true_when_name_and_destination_match() {
        //arrange
        var destination = new Location();
        var exit1 = new Exit("Door", destination);
        var exit2 = new Exit("Door", destination, "door", "do");

        //act
        var result = exit1.equals(exit2);

        //assert
        assertTrue(result);
    }

    @Test
    public void equals_should_be_false_when_compared_to_non_exit() {
        //arrange
        var destination = new Location();
        var exit1 = new Exit("Door", destination);

        //act
        var result = exit1.equals("Door");

        //assert
        assertFalse(result);
    }
    @Test
    public void equals_should_be_true_when_name_and_destinations_match_of_course() {
        //arrange
        var exit1 = new Exit("Door", new Location());
        var exit2 = new Exit("Door", new Location(), "door", "do");

        //act
        var result = exit1.equals(exit2);

        //assert
        assertTrue(result);
    }
}

