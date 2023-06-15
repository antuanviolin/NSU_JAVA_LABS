package ru.nsu.ccfit.violin.operation;

import ru.nsu.ccfit.violin.calcException.OperationException;
import ru.nsu.ccfit.violin.runtimeContext.RuntimeContext;
import ru.nsu.ccfit.violin.stack.MyStack;

public interface ContextOperation<T> extends Operation<T> {
    void apply(RuntimeContext<T> context) throws OperationException;
}
