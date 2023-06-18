package ru.nsu.ccfit.violin.operation;

import ru.nsu.ccfit.violin.calcException.OperationNotEnoughOperands;
import ru.nsu.ccfit.violin.calcException.ReferenceToEmptyStack;
import ru.nsu.ccfit.violin.calcException.WrongArgumentException;
import ru.nsu.ccfit.violin.main.Main;
import ru.nsu.ccfit.violin.stack.MyStack;

import java.util.logging.Level;


public class SqrtD implements ArithmeticOperation<Double> {
    @Override
    public void apply(MyStack<Double> stack) throws OperationNotEnoughOperands, WrongArgumentException  {
        try {
            double argument = stack.pop();
            if (argument == -1){
                stack.push(argument);
                throw new WrongArgumentException(this);
            }
            double result = Math.sqrt(argument);
            Main.logger.log(Level.INFO, "Result: "+result);
            stack.push(result);
        } catch (ReferenceToEmptyStack e){
            throw new OperationNotEnoughOperands(this);
        }
    }
}
