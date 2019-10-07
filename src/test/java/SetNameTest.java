import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.commands.Command;
import org.improving.tag.commands.SetCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SetNameTest {
    SetCommand target;
    TestInputOutput io;
    Game game;
    Player player;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new SetCommand(io);
        game =  mock(Game.class);//creating a new mock Game. Getting the actually class, not an instance of the class.

        Player player = new Player(null, null);
        player = spy(player);
        player.setName("hi");
        player.setHitPoints(50);

        when(game.getPlayer()).thenReturn(player); //when games get player method is called, we want you to return as THIS player (the one we created above)
    }


    @Test
    public void execute_should_set_Name() {
        Player player = new Player(null, null);//don't need location because testing setting name, not about setting location.
        player = spy(player);//follows player around and reports on everything it does. Wrapping it with a "spy". don't talk to the Player itself, talk to the spy player (sort of like mock)
        player.setName("hi");
        player.setHitPoints(50);

        when(game.getPlayer()).thenReturn(player); //when games get player method is called, we want you to return as THIS player

        //Act
        target.execute("@set name=Fluefedor", game);//had to call instance of game here because required parameter

        //Assert
        verify(player).setName("Fluefedor");
    }

    @Test
    public void execute_should_display_all_words_but_setName() {
        //Act
        target.execute("@set name=Fluefedor", game); //had to call instance of game here

        //Assert
        assertEquals("Your name is now Fluefedor.", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_setName_with_spaces() {
        //Act
        target.execute("   @set name=Fluefedor  ", game); //had to call instance of game here

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

