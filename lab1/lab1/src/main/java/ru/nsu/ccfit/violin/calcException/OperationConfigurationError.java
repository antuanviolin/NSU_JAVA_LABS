package ru.nsu.ccfit.violin.calcException;


import ru.nsu.ccfit.violin.operation.CustomizableOperation;
import ru.nsu.ccfit.violin.operation.Operation;

public class OperationConfigurationError extends Throwable {
    OperationConfigurationError(CustomizableOperation _operation){
        opName = _operation.toString();
    }

    @Override
    public String getMessage(){
        return "<"+opName+"> configuration error.";
    }

    final String opName;
}
