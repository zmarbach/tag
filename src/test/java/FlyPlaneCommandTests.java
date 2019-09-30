import org.improving.tag.commands.FlyPlaneCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlyPlaneCommandTests {
    TestInputOutput io;
    FlyPlaneCommand target;

    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new FlyPlaneCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {

        //act
        target.execute("Fly a plane south", null);

        //assert
        assertEquals("You fly south...", io.lastText);

    }

    @Test
    public void is_Valid_should_be_true_when_input_is_fly_a_plane() {

        //act
        var result = target.isValid("fly a plane south", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_should_return_true_if_input_is_fly_a_plane_with_spaces(){

        //act
        var result = target.isValid("   fly a plane south   ", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_is_true_if_input_is_fly_a_plane_with_caps() {

        //act
        var result = target.isValid("FLY a PLAne SOUth", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_valid_should_be_false_if_input_is_not_fly_a_plane(){

        //act
        var result = target.isValid("hghghf", null);

        //assert
        assertFalse(result);
    }

    @Test
    public void is_valid_should_be_false_if_input_is_only_one_word() {
        //act
        var result = target.isValid("fly", null);

        //assert
        assertFalse(result);
    }

    @Test
    public void is_valid_should_be_false_if_input_is_only_two_word() {
        //act
        var result = target.isValid("fly a", null);

        //assert
        assertFalse(result);
    }

    @Test
    public void is_valid_should_be_false_if_input_is_null() {
        //act
        var result = target.isValid(null, null  );

        //assert
        assertFalse(result);
    }
}

