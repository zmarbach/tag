import org.improving.tag.InputOutput;
import org.improving.tag.commands.DanceCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DanceCommandTests {

    DanceCommand target;
    TestInputOutput io;

    //have to declare target first so it can be used in methods below
    //cant var here because we arent initializing, so dont have the Type on the other side of equals sign.

    @BeforeEach
    //before you run each test, run this method first! Does the arrange portion of test first for each.
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new DanceCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        //Arrange


        //Act
        target.execute(null);

        //Assert
        assertEquals("You dance around.", io.lastText);
        // this is saying that the 1st parameter = 2nd parameter
    }
    @Test
    public void isValid_should_be_true_when_input_is_dance () {
        //Arrange


        //Act
        var result = target.isValid("dance");

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
    public void isValid_should_be_true_when_input_is_dance_with_spaces() {
        //Arrange


        //Act
        var result = target.isValid("   dance   ");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_caps() {
        //Arrange


        //Act
        var result = target.isValid("DANce"); //no spaces here cuz need to test ONLY ONE THING

        //Assert
        assertTrue(result);
    }



}

