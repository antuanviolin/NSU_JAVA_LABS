package ru.nsu.ccfit.violin.calcException;

import ru.nsu.ccfit.violin.operation.Operation;

public class NotDefined extends ContextException{
    public NotDefined(Operation<?> operation, String _notDefinedString){
        super(operation);
        notDefinedString = _notDefinedString;
    }

    @Override
    public String getMessage(){
        return "Value \""+notDefinedString+"\" is not defined <- "+super.getMessage();
    }

    final String notDefinedString;
}
