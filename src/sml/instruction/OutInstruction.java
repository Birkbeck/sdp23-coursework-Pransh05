package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;
// TODO: write a JavaDoc for the class
// This class implements out instruction

/**
 * @author Priya Goel
 */
public class OutInstruction extends Instruction {
    private final RegisterName source;

    public static final String OP_CODE = "out";


    public OutInstruction(String label, RegisterName source) {
        super(label, OP_CODE);
        this.source = source;
    }


    /**
     * Executes the instruction in the given machine.
     *
     * @param m the machine the instruction runs on
     * @return the new program counter (for jump instructions)
     * or NORMAL_PROGRAM_COUNTER_UPDATE to indicate that
     * the instruction with the next address is to be executed
     */
    @Override
    public int execute(Machine m) {
        int value = m.getRegisters().get(source);
        System.out.println("Value :: "+value);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + source;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof OutInstruction other) {
            return Objects.equals(this.label, other.label)
                    && Objects.equals(source, other.source);
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(label, source);
    }
}
