package sml.instructionfactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.RegisterName;
import sml.Registers;
import sml.instruction.AddInstruction;

import java.util.function.Function;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

public class AddInstructionFactoryTest {
    private static final Function<String, RegisterName> registerValue = Registers.Register::valueOf;
    private static final InstructionFactory factory = new AddInstructionFactory(registerValue);
    private int paramIndex;

    private String getRegisterValues(String... params) {
        if(paramIndex < params.length){
            return params[paramIndex++];
        }
        return null;
    }

    @BeforeEach
    void setUp() {
        paramIndex = 0;
    }

    @Test
    void executeValid() {
        String label = null;
        String[] regArgs = {"EAX", "EBX"};
        Instruction actualIns = factory.create(label, () -> getRegisterValues(regArgs));
        AddInstruction expectedResult = new AddInstruction(label, EAX, EBX);

        Assertions.assertEquals(expectedResult, actualIns);
    }

    @Test
    void executeValidTwo() {
        String label = "L1";
        String[] regArgs = {"EAX", "EBX"};

        Instruction actualIns = factory.create(label, () -> getRegisterValues(regArgs));
        AddInstruction expectedResult = new AddInstruction(label, EAX, EBX);

        Assertions.assertEquals(expectedResult, actualIns);
    }
}
