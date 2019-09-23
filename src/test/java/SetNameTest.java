import org.improving.tag.Game;
import org.improving.tag.commands.Command;
import org.improving.tag.commands.SetCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetNameTest {
    SetCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new SetCommand(io);
    }

    @Test
    public void execute_should_display_all_words_but_setName() {
        //Act
        target.execute("@set name=Fluefedor", new Game(null, io));

        //Assert
        assertEquals("Your name is now Fluefedor.", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_setName_with_spaces() {
        //Act
        target.execute("   @set name=Fluefedor   ", new Game(null, io)); //had to call come instance of game here

        //Assert
        assertEquals("Your name is now Fluefedor.", io.lastText);
    }
    @Test
    public void isValid_should_be_true_when_input_is_setName () {
        //Arrange


        //Act
        var result = target.isValid("@set name=Fluefedor", null);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is__setName_with_spaces() {
        //Arrange


        //Act
        var result = target.isValid("   @set name= Fluefedor   ", null);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_setName_with_caps() {
        //Arrange


        //Act
        var result = target.isValid("@set NaME=FluefEDor", null);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {
        //Arrange

        //Act
        var result = target.isValid("foobar", null);

        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {
        //Arrange

        //Act
        var result = target.isValid(null, null);

        //Assert
        assertFalse(result);

    }
    @Test
    public void isValid_should_be_false_when_input_is_only_one_word() {
        //Arrange

        //Act
        var result = target.isValid("@set", null);

        //Assert
        assertFalse(result);

    }
}

