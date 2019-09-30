import org.improving.tag.commands.InventoryCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryCommandTests {
    TestInputOutput io;
    InventoryCommand target;

    @Test
    public void execute_should_return_phrase() {
        //arrange
        io = new TestInputOutput();
        target = new InventoryCommand(io);

        //act
        target.execute(null, null);

        //assert
        assertEquals("You are carrying nothing.", io.lastText);

    }

    @Test
    public void is_Valid_should_be_true_when_input_is_inventory() {
        //arrange
        io = new TestInputOutput();
        target = new InventoryCommand(io);

        //act
        var result = target.isValid("inventory", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_should_return_true_if_input_is_inventory_with_spaces(){
        //arrancge
        io = new TestInputOutput();
        target = new InventoryCommand(io);

        //act
        var result = target.isValid("   inventory   ", null);

        //assert
        assertTrue(result);
    }

    @Test
    public void is_Valid_is_true_if_input_is_inventory_with_caps() {
        //arrange
        io = new TestInputOutput();
        target = new InventoryCommand(io);

        //act
        var result = target.isValid("INVentorY", null);

        //assert
        assertTrue(result);
    }
    @Test
    public void is_valid_should_be_false_if_input_is_not_inventory(){
        //arrange
        io = new TestInputOutput();
        target = new InventoryCommand(io);

        //act
        var result = target.isValid("hghghf", null);

        //assert
        assertFalse(result);
    }
}
