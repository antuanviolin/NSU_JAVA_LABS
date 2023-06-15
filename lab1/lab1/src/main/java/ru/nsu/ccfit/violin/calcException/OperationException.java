package ru.nsu.ccfit.violin.calcException;

import ru.nsu.ccfit.violin.operation.Operation;

public class OperationException extends Throwable{
    OperationException(Operation<?> operation){
        operationName = operation.toString();
    }
    @Override
    public String getMessage(){
        return "Operation <"+operationName+"> error. ";
    }

    final String operationName;
}
