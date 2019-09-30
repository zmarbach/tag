import org.improving.tag.commands.BaseEmoteCommand;
import org.improving.tag.commands.ClimbCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClimbCommandTests {
    TestInputOutput io;
    ClimbCommand target;

    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new ClimbCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        //arrange


        //act
        target.execute(null, null   );

        //assert
        assertEquals("You climb up the cliff.", io.lastText);

    }

    @Test
    public void is_Valid_return_true_if_input_is_climb() {
        //act
        var result = target.isValid("climb", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is_climb_with_spaces() {
        //act
        var result = target.isValid("    climb   ", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_true_if_input_is_climb_with_caps() {
        //act
        var result = target.isValid("CLiMb", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_false_if_input_is_not_climb() {
        //act
        var result = target.isValid("jibberish", null);

        //assert
        assertFalse(result);
    }

}
