package sml.instructionfactory;

import sml.Instruction;

import java.util.function.Supplier;

/**
 * This interface used for creating instruction factory.
 *
 * @author Priya Goel
 */
public interface InstructionFactory {
    /**
     * Returns an instance of a machine instruction created from the details
     * of the translated program instruction
     *
     * @param label label of a program instruction
     * @param consParam used in the program instruction (can be registers, values, labels)
     * @return an instance of a machine instruction
     */
    Instruction create (String label, Supplier<String> consParam);
}
