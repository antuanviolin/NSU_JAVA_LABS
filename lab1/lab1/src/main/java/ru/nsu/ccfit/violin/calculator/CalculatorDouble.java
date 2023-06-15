package ru.nsu.ccfit.violin.calculator;

import ru.nsu.ccfit.violin.calcException.*;
import ru.nsu.ccfit.violin.main.Main;
import ru.nsu.ccfit.violin.operation.ArithmeticOperation;
import ru.nsu.ccfit.violin.operation.ContextOperation;
import ru.nsu.ccfit.violin.operation.Operation;
import ru.nsu.ccfit.violin.operation.StackOperation;
import ru.nsu.ccfit.violin.runtimeContext.RuntimeContextD;
import ru.nsu.ccfit.violin.stack.MyStack;

import java.util.logging.Level;

public class CalculatorDouble implements Calculator<Double> {
    private final MyStack<Double> stack = new MyStack<>();
    private final RuntimeContextD context = new RuntimeContextD();

    @Override
    public void execute(Operation<Double> operation) {
        Main.logger.log(Level.INFO, operation.toString()+" starts to execute by calculator.");
        if(operation instanceof ArithmeticOperation){
            try {
                operation.apply(stack);
            } catch (OperationException e){
                System.out.println(e.getMessage());
                Main.logger.log(Level.WARNING, operation.toString()+"---"+e.getMessage());
            }
        }
        else if (operation instanceof StackOperation){
            try {
                operation.apply(stack, context);
            } catch (StackException | OperationException | OperationConfigurationError e) {
                System.out.println(e.getMessage());
                Main.logger.log(Level.WARNING, operation.toString()+"---"+e.getMessage());
            }
        }
        else if (operation instanceof ContextOperation){
            try {
                operation.apply(context);
            } catch (OperationException e) {
                System.out.println(e.getMessage());
                Main.logger.log(Level.WARNING, operation.toString()+"---"+e.getMessage());
            }
        }
    }
}
