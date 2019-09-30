import org.improving.tag.commands.JumpCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JumpCommandTests {
    TestInputOutput io;
    JumpCommand target;

    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new JumpCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        //arrange


        //act
        target.execute(null, null   );

        //assert
        assertEquals("You jump in the air.", io.lastText);

    }

    @Test
    public void is_Valid_return_true_if_input_is_jump() {
        //act
        var result = target.isValid("jump", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is_jump_with_spaces() {
        //act
        var result = target.isValid("    jump   ", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_true_if_input_is_jump_with_caps() {
        //act
        var result = target.isValid("JUMp", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_false_if_input_is_not_jump() {
        //act
        var result = target.isValid("jibberish", null);

        //assert
        assertFalse(result);
    }

}
