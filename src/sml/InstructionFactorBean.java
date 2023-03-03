package sml;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sml.instructionfactory.InstructionFactory;

/**
 * Represents an instruction factory creator.
 *
 * @author Priya Goel
 */
public class InstructionFactorBean {
    private static volatile InstructionFactorBean instance;

    /**
     * Spring application context
     */
    private final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    /**
     * Returns the instance of this singleton class.
     *
     * @return the instance of this singleton class
     */
    public static InstructionFactorBean getInstance() {
        InstructionFactorBean result = instance;
        if (result != null) {
            return result;
        }
        synchronized (InstructionFactorBean.class) {
            if (instance == null) {
                instance = new InstructionFactorBean();
            }
            return instance;
        }
    }

    /**
     * Returns an instruction factory corresponding to the opcode provided.
     *
     * @param opcode the instruction's opcode
     * @return an instruction factory corresponding to the opcode provided
     */
    public InstructionFactory getInstructionFactory(String opcode) {
        try {
            return context.getBean(opcode, InstructionFactory.class);
        } catch (BeansException e) {
            throw new RuntimeException("No instruction '" + opcode + "' available");
        }
    }
}

