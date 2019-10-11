import org.improving.tag.Game;
import org.improving.tag.WorldBuilder;
import org.improving.tag.commands.JumpCommand;
import org.improving.tag.commands.WhoAmICommand;
import org.improving.tag.database.LocationDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class WhoAmICommandTests {
    TestInputOutput io;
    WhoAmICommand target;
    Game game;

    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new WhoAmICommand(io);
        game = new Game(null, io, null, new WorldBuilder(null, null));
    }

    @Test
    public void execute_should_return_phrase() {
        //act
        target.execute(null, game);

        //assert
        assertEquals("My name is The Player", io.lastText);

    }

    @Test
    public void is_Valid_return_true_if_input_is_whoami() {
        //act
        var result = target.isValid("whoami", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_false_if_input_is_whoami_with_spaces_btwn() {
        //act
        var result = target.isValid("who am i", null);

        //assert
        assertFalse(result);
    }
    @Test
    public void is_Valid_should_be_true_if_input_is_whoami_with_spaces_before_and_after(){
        //act
        var result = target.isValid("   whoami   ", null);

        //assert
        assertTrue(result);

        }
    @Test
    public void is_Valid_return_true_if_input_is_whoami_with_caps() {
        //act
        var result = target.isValid("WhOamI", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_false_if_input_is_not_whoami() {
        //act
        var result = target.isValid("jibberish", null);

        //assert
        assertFalse(result);
    }

}

