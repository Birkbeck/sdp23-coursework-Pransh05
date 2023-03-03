package sml.instructionfactory;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.RegisterName;
import sml.instruction.MulInstruction;

import java.util.function.Function;
import java.util.function.Supplier;
/*This class contain information about multiply instruction factory.
 *
 * @author Priya Goel
 */

@Component(MulInstruction.OP_CODE)
public class MulInstructionFactory implements InstructionFactory{
    private final Function<String, RegisterName> registerValue;
    public MulInstructionFactory(Function<String, RegisterName> registerValue) {
        this.registerValue = registerValue;
    }

    /**
     * Returns an instance of a machine instruction created from the details
     * of the translated program instruction
     *
     * @param label     label of a program instruction
     * @param consParam used in the program instruction (can be registers, values, labels)
     * @return an instance of a machine instruction
     */
    @Override
    public Instruction create(String label, Supplier<String> consParam) {
        return new MulInstruction(label, registerValue.apply(consParam.get()),
                registerValue.apply(consParam.get()));
    }
}


