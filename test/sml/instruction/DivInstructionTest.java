package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

class DivInstructionTest {
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
    registers.set(EAX, 12);
    registers.set(EBX, 6);
    Instruction instruction = new DivInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(2, machine.getRegisters().get(EAX));
  }

  @Test
  void executeValidTwo() {
    registers.set(EAX, -35);
    registers.set(EBX, 6);
    Instruction instruction = new DivInstruction(null, EAX, EBX);
    instruction.execute(machine);
    Assertions.assertEquals(-5, machine.getRegisters().get(EAX));
  }
}