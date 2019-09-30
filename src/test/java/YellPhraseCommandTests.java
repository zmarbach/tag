import org.improving.tag.commands.YellPhraseCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YellPhraseCommandTests {
    TestInputOutput io;
    YellPhraseCommand target;

    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new YellPhraseCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        //arrange


        //act
        target.execute("yell something", null   );

        //assert
        assertEquals("You yell something!!!", io.lastText);

    }

    @Test
    public void is_Valid_return_true_if_input_is_yell_followed_by_more_words() {
        //act
        var result = target.isValid("yell something", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is_yell_with_spaces() {
        //act
        var result = target.isValid("    yell   something", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_true_if_input_is_yell_with_caps() {
        //act
        var result = target.isValid("YElL something", null);

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

    @Test
    public void is_Valid_is_false_if_input_is_only_yell_followed_by_no_other_words() {
        //act
        var result = target.isValid("yell", null);

        //assert
        assertFalse(result);
    }

}

