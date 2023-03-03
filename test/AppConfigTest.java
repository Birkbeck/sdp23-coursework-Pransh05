import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sml.AppConfig;
import sml.instructionfactory.InstructionFactory;
import sml.instruction.*;

import java.util.function.Function;

public class AppConfigTest {
    private static ApplicationContext context;

    @BeforeAll
    static void setUp() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @AfterAll
    static void tearDown() {
        context = null;
    }

    @Test
    public void beanExist() {
        Assertions.assertNotNull(context.getBean(Function.class));
    }

    @Test
    public void addInsFactoryExist() {
        Assertions.assertNotNull(context.getBean(AddInstruction.OP_CODE, InstructionFactory.class));
    }

    @Test
    public void subInsFactoryExist() {
        Assertions.assertNotNull(context.getBean(SubInstruction.OP_CODE, InstructionFactory.class));
    }

    @Test
    public void mulInsFactoryExist() {
        Assertions.assertNotNull(context.getBean(MulInstruction.OP_CODE, InstructionFactory.class));
    }

    @Test
    public void divInsFactoryExist() {
        Assertions.assertNotNull(context.getBean(DivInstruction.OP_CODE, InstructionFactory.class));
    }

    @Test
    public void movInsFactoryExist() {
        Assertions.assertNotNull(context.getBean(MovInstruction.OP_CODE, InstructionFactory.class));
    }

    @Test
    public void outInsFactoryExist() {
        Assertions.assertNotNull(context.getBean(OutInstruction.OP_CODE, InstructionFactory.class));
    }

    @Test
    public void jnzInsFactoryExist() {
        Assertions.assertNotNull(context.getBean(JnzInstruction.OP_CODE, InstructionFactory.class));
    }
}
