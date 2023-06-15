package ru.nsu.ccfit.violin.operation;

import ru.nsu.ccfit.violin.calcException.ReferenceToEmptyStack;
import ru.nsu.ccfit.violin.main.Main;
import ru.nsu.ccfit.violin.runtimeContext.RuntimeContext;
import ru.nsu.ccfit.violin.stack.MyStack;

import java.util.logging.Level;

public class PopD implements StackOperation<Double>{
    @Override
    public void apply(MyStack<Double> stack, RuntimeContext<Double> context) throws ReferenceToEmptyStack {
        stack.print();
        Main.logger.log(Level.INFO, "Pop'ed: "+stack.pop());
    }
}
