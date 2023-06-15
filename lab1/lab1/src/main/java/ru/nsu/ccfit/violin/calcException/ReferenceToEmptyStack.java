package ru.nsu.ccfit.violin.calcException;

public class ReferenceToEmptyStack extends StackException{
    @Override
    public String getMessage(){
        return "Reference to empty stack <- " + super.getMessage();
    }
}
