import org.improving.tag.commands.MoveCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveCommandTests {
    MoveCommand target;
    TestInputOutput io;

    //have to declare target first so it can be used in methods below
    //cant var here because we arent initializing, so dont have the Type on the other side of equals sign.

    @BeforeEach
    //before you run each test, run this method first! Does the arrange portion of test first for each.
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new MoveCommand(io);
    }

    @Test
    public void execute_should_display_all_words_but_move() {
        //Act
        target.execute("Move to the moon");

        //Assert
        assertEquals("You proceed to the moon.", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_move_with_spaces() {
        //Act
        target.execute("Move to the moon");

        //Assert
        assertEquals("You proceed to the moon.", io.lastText);
    }
    @Test
    public void isValid_should_be_true_when_input_is_move () {
        //Arrange


        //Act
        var result = target.isValid("move to the moon");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_move_with_spaces() {
        //Arrange


        //Act
        var result = target.isValid("   move to the moon   ");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_move_with_caps() {
        //Arrange


        //Act
        var result = target.isValid("MoVe to THe MooN"); //no spaces here cuz need to test ONLY ONE THING

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {
        //Arrange

        //Act
        var result = target.isValid("foobar");

        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {
        //Arrange

        //Act
        var result = target.isValid(null);// this fails because cant trim a NULL (trim is called in BAseEmoteCommand

        //Assert
        assertFalse(result);

    }
    @Test
    public void isValid_should_be_false_when_input_is_only_one_word() {
        //Arrange

        //Act
        var result = target.isValid("move");

        //Assert
        assertFalse(result);

    }
}
