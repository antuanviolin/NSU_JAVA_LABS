package ru.nsu.ccfit.violin.operation;

import ru.nsu.ccfit.violin.calcException.OperationConfigurationError;

public interface CustomizableOperation {
    void set(String[] option) throws OperationConfigurationError;
}
