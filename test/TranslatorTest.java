import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.*;
import sml.instruction.*;

import java.util.ArrayList;
import java.util.List;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

public class TranslatorTest {
    private Machine machine;
    private Labels label;
    String fileName = "test1";
    @BeforeEach
    void setUp() {
        this.machine = new Machine(new Registers());
        this.label = new Labels();
    }

    @AfterEach
    void tearDown() {
        this.machine = null;
        this.label = null;
    }

    @Test
    void executeValid() throws Exception {
        Translator t = new Translator(fileName);
        t.readAndTranslate(this.machine.getLabels(), this.machine.getProgram());

        label.addLabel("T1", 0);

        List<Instruction> testInstruction = new ArrayList<>();
        testInstruction.add(new MovInstruction("T1", EAX,10));
        testInstruction.add(new AddInstruction(null, EAX, EBX));
        testInstruction.add(new DivInstruction(null, EAX, EBX));
        testInstruction.add(new SubInstruction(null, EBX, EAX));
        testInstruction.add(new MulInstruction(null, EAX, EBX));
        testInstruction.add(new OutInstruction(null, EAX));
        testInstruction.add(new JnzInstruction(null, EAX, "T1"));

        Assertions.assertAll(() -> Assertions.assertEquals(this.machine.getLabels(), label),
                () -> Assertions.assertEquals(this.machine.getProgram(), testInstruction));
    }

}
