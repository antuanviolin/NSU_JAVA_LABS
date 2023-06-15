package ru.nsu.ccfit.violin.operation;

import ru.nsu.ccfit.violin.calcException.OperationException;
import ru.nsu.ccfit.violin.calcException.ReferenceToEmptyStack;
import ru.nsu.ccfit.violin.calcException.WrongFormatInputData;
import ru.nsu.ccfit.violin.runtimeContext.RuntimeContext;
import ru.nsu.ccfit.violin.stack.MyStack;

public interface Operation<T> {
    default void apply(MyStack<T> stack) throws OperationException {}
    default void apply(MyStack<T> stack, RuntimeContext<T> context) throws OperationException, ReferenceToEmptyStack, WrongFormatInputData {}
    default void apply(RuntimeContext<T> context) throws OperationException {}
}
