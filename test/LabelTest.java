import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.*;
import sml.instruction.*;
public class LabelTest {
    private Labels label;

    @BeforeEach
    void setUp() {
        label = new Labels();
        label.addLabel("L1", 1);
        label.addLabel("L2", 2);
    }

    @AfterEach
    void tearDown() {
        label = null;
    }

    @Test
    void executePrint() {
        Assertions.assertEquals("[L1 -> 1, L2 -> 2]", label.toString());
    }

    @Test
    void checkNullLabel() {
        String testLabel = "L1";
        Assertions.assertThrows(NullPointerException.class, () ->label.getAddress(testLabel));
    }

    @Test
    void checkDuplicateLabel() {
        String testLabel = "L1";
        label.addLabel(testLabel, 1);
        Assertions.assertThrows(RuntimeException.class, ()->label.addLabel(testLabel, 1));
    }
}
