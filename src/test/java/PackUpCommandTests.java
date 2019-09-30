import net.bytebuddy.build.ToStringPlugin;
import org.improving.tag.commands.JumpCommand;
import org.improving.tag.commands.PackUpCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PackUpCommandTests {
    TestInputOutput io;
    PackUpCommand target;

    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new PackUpCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        //arrange


        //act
        target.execute(null, null   );

        //assert
        assertEquals("You pack your bags.", io.lastText);

    }

    @Test
    public void is_Valid_return_true_if_input_is_jump() {
        //act
        var result = target.isValid("pack up", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_false_if_input_is_packup_all_one_word() {
        //act
        var result = target.isValid("packup", null);

        //assert
        assertFalse(result);

    }

    @Test
    public void is_Valid_return_true_if_input_is_jump_with_spaces() {
        //act
        var result = target.isValid("    pack up   ", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_true_if_input_is_jump_with_caps() {
        //act
        var result = target.isValid("PACk Up", null);

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
