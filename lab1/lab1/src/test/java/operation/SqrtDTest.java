package operation;

import ru.nsu.ccfit.violin.calcException.OperationException;
import ru.nsu.ccfit.violin.calcException.ReferenceToEmptyStack;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.violin.operation.Operation;
import ru.nsu.ccfit.violin.operation.SqrtD;
import ru.nsu.ccfit.violin.stack.MyStack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqrtDTest {
    private final GeneralResourses resourses = new GeneralResourses();
    private final Operation<Double> operation = new SqrtD();

    @Test
    void apply() throws OperationException, ReferenceToEmptyStack {
        MyStack<Double> stack = resourses.stack;
        for(double val : GeneralResourses.testData) {
            stack.push(val);
            operation.apply(stack);
            assertEquals(stack.pop(), Math.sqrt(val));
        }
    }
}