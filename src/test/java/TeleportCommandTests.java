import org.improving.tag.commands.TeleportCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeleportCommandTests {
    TestInputOutput io;
    TeleportCommand target;

    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new TeleportCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        //arrange


        //act
        target.execute(null, null   );

        //assert
        assertEquals("You phase out of existence.", io.lastText);

    }

    @Test
    public void is_Valid_return_true_if_input_is_teleport() {
        //act
        var result = target.isValid("teleport", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is_teleport_with_spaces() {
        //act
        var result = target.isValid("    teleport  ", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_true_if_input_is_teleport_with_caps() {
        //act
        var result = target.isValid("TelEPORT", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_false_if_input_is_not_teleport() {
        //act
        var result = target.isValid("jibberish", null);

        //assert
        assertFalse(result);
    }

}
