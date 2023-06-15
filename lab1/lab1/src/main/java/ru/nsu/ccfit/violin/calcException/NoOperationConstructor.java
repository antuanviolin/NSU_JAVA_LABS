package ru.nsu.ccfit.violin.calcException;

public class NoOperationConstructor extends CreationError{
    public NoOperationConstructor (String _operationName){
        super(_operationName);
    }
    @Override
    public String getMessage(){
        return "No construct method <- "+super.getMessage();
    }
}
