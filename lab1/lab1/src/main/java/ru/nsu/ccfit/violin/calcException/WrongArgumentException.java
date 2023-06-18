package ru.nsu.ccfit.violin.calcException;

import ru.nsu.ccfit.violin.operation.Operation;

public class WrongArgumentException extends OperationException{
    public WrongArgumentException(Operation<?> operation) {
        super(operation);
    }
    @Override
    public String getMessage(){
        return "Wrong argument for operation <- "+ super.getMessage();
    }
}
