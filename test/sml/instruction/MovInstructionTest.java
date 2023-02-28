package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.EAX;

public class MovInstructionTest {
    private Machine machine;
    private Registers registers;

    @BeforeEach
    void setUp() {
        machine = new Machine(new Registers());
        registers = machine.getRegisters();
        //...
    }

    @AfterEach
    void tearDown() {
        machine = null;
        registers = null;
    }

    @Test
    void executeValid() {
        int testValue = 12;
        Instruction instruction = new MovInstruction(null, EAX, testValue);
        instruction.execute(machine);
        Assertions.assertEquals(testValue, machine.getRegisters().get(EAX));
    }

    @Test
    void executeValidTwo() {
        int testValue = -35;
        Instruction instruction = new MovInstruction(null, EAX, testValue);
        instruction.execute(machine);
        Assertions.assertEquals(testValue, machine.getRegisters().get(EAX));
    }
}
