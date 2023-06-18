package ru.nsu.ccfit.violin.calcException;

import ru.nsu.ccfit.violin.operation.Operation;

public class OperationNotEnoughOperands extends OperationException{
    public OperationNotEnoughOperands(Operation<?> operation) {
        super(operation);
    }
    @Override
    public String getMessage(){
        return "Not enough operands for operation <- "+ super.getMessage();
    }
}
