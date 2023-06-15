package operation;

import ru.nsu.ccfit.violin.calcException.NotDefined;
import ru.nsu.ccfit.violin.calcException.NotEnoughOperandToConfigure;
import ru.nsu.ccfit.violin.calcException.ReferenceToEmptyStack;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.violin.operation.PopD;

import static org.junit.jupiter.api.Assertions.*;

class PopDTest {
    private final GeneralResourses resourses = new GeneralResourses();
    private final PopD pop = new PopD();

    @Test
    void apply() throws ReferenceToEmptyStack, NotEnoughOperandToConfigure, NotDefined {
        assertThrowsExactly(ReferenceToEmptyStack.class, ()->pop.apply(resourses.stack, resourses.context));

        resourses.stack.push(5.0);
        pop.apply(resourses.stack, resourses.context);
        assertThrowsExactly(ReferenceToEmptyStack.class, ()->pop.apply(resourses.stack, resourses.context));
    }
}