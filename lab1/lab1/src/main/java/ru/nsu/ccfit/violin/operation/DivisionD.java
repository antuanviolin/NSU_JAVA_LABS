package ru.nsu.ccfit.violin.operation;

import ru.nsu.ccfit.violin.calcException.OperationNotEnoughOperands;
import ru.nsu.ccfit.violin.calcException.OperationZeroDivision;
import ru.nsu.ccfit.violin.calcException.ReferenceToEmptyStack;
import ru.nsu.ccfit.violin.main.Main;
import ru.nsu.ccfit.violin.stack.MyStack;

import java.util.logging.Level;

public class DivisionD implements ArithmeticOperation<Double> {
    @Override
    public void apply(MyStack<Double> stack) throws OperationNotEnoughOperands, OperationZeroDivision {
        try {
            double secondOp = stack.pop();
            double firstOp = stack.pop();
            if(secondOp == 0){
                throw new OperationZeroDivision(this);
            }
            double result = firstOp / secondOp;
            Main.logger.log(Level.INFO, "Result: "+result);
            stack.push(result);
        } catch (ReferenceToEmptyStack e){
            throw new OperationNotEnoughOperands(this);
        }
    }
}
