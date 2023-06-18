package ru.nsu.ccfit.violin.calcException;

import ru.nsu.ccfit.violin.operation.Operation;

public class OperationZeroDivision extends OperationException {
    public OperationZeroDivision(Operation<?> op){
        super(op);
    }

    @Override
    public String getMessage(){
        return "Zero division <-" + super.getMessage();
    }

}
