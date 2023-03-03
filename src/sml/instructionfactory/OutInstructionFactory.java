package sml.instructionfactory;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.RegisterName;
import sml.instruction.OutInstruction;

import java.util.function.Function;
import java.util.function.Supplier;

/*This class contain information about add instruction factory.
*
* @author Priya Goel
 */
@Component(OutInstruction.OP_CODE)
public class OutInstructionFactory implements InstructionFactory {

    private final Function<String, RegisterName> registerValue;
    public OutInstructionFactory(Function<String, RegisterName> registerValue) {
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
        return new OutInstruction(label, registerValue.apply(consParam.get()));
    }
}
