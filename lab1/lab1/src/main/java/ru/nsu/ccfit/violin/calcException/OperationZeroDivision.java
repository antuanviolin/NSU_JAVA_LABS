package ru.nsu.ccfit.violin.calcException;

import ru.nsu.ccfit.violin.operation.Operation;

public class OperationZeroDivision extends java.lang.ArithmeticException {
    public OperationZeroDivision(Operation<?> op){
        super(op.toString());
    }

    @Override
    public String getMessage(){
        return "Zero division <-" + super.getMessage();
    }

}
