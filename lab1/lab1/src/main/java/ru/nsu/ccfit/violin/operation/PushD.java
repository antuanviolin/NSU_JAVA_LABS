package ru.nsu.ccfit.violin.operation;

import ru.nsu.ccfit.violin.calcException.NotDefined;
import ru.nsu.ccfit.violin.calcException.NotEnoughOperandToConfigure;
import ru.nsu.ccfit.violin.calcException.WrongFormatInputData;
import ru.nsu.ccfit.violin.main.Main;
import ru.nsu.ccfit.violin.runtimeContext.RuntimeContext;
import ru.nsu.ccfit.violin.stack.MyStack;

import java.util.Objects;
import java.util.logging.Level;

public class PushD implements StackOperation<Double>, CustomizableOperation {
    private String arg;

    @Override
    public void apply(MyStack<Double> stack, RuntimeContext<Double> context) throws NotDefined {
        try {
            Double defined = context.getIfDefined(arg);
            stack.push(Objects.requireNonNullElseGet(defined, () -> Double.parseDouble(arg)));
        } catch (NumberFormatException e){
            throw new NotDefined(this, arg);
        }
    }

    @Override
    public void set(String[] option) throws NotEnoughOperandToConfigure {
        if(option.length < 2){
            throw new NotEnoughOperandToConfigure(this);
        } else {
            arg = option[1];
            //Main.logger.log(Level.INFO, this.toString()+" is configured by "+arg);
        }
    }
}
