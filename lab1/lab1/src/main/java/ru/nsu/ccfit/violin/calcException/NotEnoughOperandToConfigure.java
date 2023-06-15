package ru.nsu.ccfit.violin.calcException;

import ru.nsu.ccfit.violin.operation.CustomizableOperation;

public class NotEnoughOperandToConfigure extends OperationConfigurationError{
    public NotEnoughOperandToConfigure(CustomizableOperation operation){
        super(operation);
    }

    @Override
    public String getMessage(){
        return "Not enough operands to configure <- " + super.getMessage();
    }
}
