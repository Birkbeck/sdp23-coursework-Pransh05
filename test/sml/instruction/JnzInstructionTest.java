package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.EAX;

public class JnzInstructionTest {
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
        registers.set(EAX, 10);
        machine.getLabels().addLabel("I1",20);
        Instruction instruction = new JnzInstruction(null,EAX,"I1");
        Assertions.assertEquals(20, instruction.execute(machine));
    }

    @Test
    void JNZexecuteTestzero() {
        registers.set(EAX, 0);
        machine.getLabels().addLabel("I1",0);
        Instruction instruction = new JnzInstruction(null, EAX, "I1");
        Assertions.assertEquals(-1, instruction.execute(machine));
    }
}
