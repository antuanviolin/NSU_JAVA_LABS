package ru.nsu.ccfit.violin.calculator;

import ru.nsu.ccfit.violin.operation.Operation;

public interface Calculator<T> {
    void execute(Operation<T> operation);
}
