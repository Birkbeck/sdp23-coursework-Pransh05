package sml.instructionfactory;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.RegisterName;
import sml.instruction.MovInstruction;

import java.util.function.Function;
import java.util.function.Supplier;

/*This class contains information about move instruction factory.
*
* @author Priya Goel
 */
@Component(MovInstruction.OP_CODE)
public class MovInstructionFactory implements InstructionFactory {

    private final Function<String, RegisterName> registerValue;
    public MovInstructionFactory(Function<String, RegisterName> registerValue) {
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
        return new MovInstruction(label, registerValue.apply(consParam.get()), Integer.parseInt(consParam.get()));
    }
}
