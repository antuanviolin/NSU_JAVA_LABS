package ru.nsu.ccfit.violin.operation;

import ru.nsu.ccfit.violin.calcException.OperationException;
import ru.nsu.ccfit.violin.stack.MyStack;

public interface ArithmeticOperation<T> extends Operation<T> {
    void apply(MyStack<T> stack) throws OperationException;
}
