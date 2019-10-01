import org.improving.tag.Adversary;
import org.improving.tag.Game;
import org.improving.tag.SaveGameFactory;
import org.improving.tag.commands.AttackCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AttackCommandTests {
    TestInputOutput io;
    AttackCommand target;
    Game game;
    Adversary adv;

    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new AttackCommand(io);
        game = mock(Game.class);
        Adversary adv = new Adversary();
        adv = spy(adv);
        adv.setName("bob");
        adv.setHitPoints(100);
        adv.setDamageTaken(0);

        when(game.getPlayer().getLocation().getAdversary()).thenReturn(adv);
    }

    @Test
    public void execute_should_incr_damage_taken_by_10() {
        //arrange
        int num = 20;//ask Tim about best way to test execute Attack Command (since it has the whole random # piece)

        //act

        target.execute(null, game);

        //assert
        //verify(adv).getDamageTaken() = 90;

    }

    @Test
    public void is_Valid_return_true_if_input_is_attack() {
        //act
        var result = target.isValid("attack", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is_att() {
        //act
        var result = target.isValid("att", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_true_if_input_is_a() {
        //act
        var result = target.isValid("a", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_true_if_input_is__attack_with_spaces() {
        //act
        var result = target.isValid("    attack   ", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is__att_with_spaces() {
        //act
        var result = target.isValid("    att   ", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is__a_with_spaces() {
        //act
        var result = target.isValid("    a   ", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_true_if_input_is_attack_with_caps() {
        //act
        var result = target.isValid("ATtaCK", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is_att_with_caps() {
        //act
        var result = target.isValid("ATt", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_return_true_if_input_is_capital_A() {
        //act
        var result = target.isValid("A", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_Valid_return_false_if_input_is_not_attack_or_att_or_a() {
        //act
        var result = target.isValid("jibberish", null);

        //assert
        assertFalse(result);
    }

}

