package ru.nsu.ccfit.violin.calcException;

import ru.nsu.ccfit.violin.operation.Operation;

public class ArithmeticException extends OperationException{
    ArithmeticException(Operation<?> op){
        super(op);
    }
    @Override
    public String getMessage(){
        return " Arithmetic Exception <-" + super.getMessage();
    }
}
