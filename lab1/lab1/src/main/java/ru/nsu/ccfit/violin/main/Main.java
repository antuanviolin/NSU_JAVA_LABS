package ru.nsu.ccfit.violin.main;

import ru.nsu.ccfit.violin.calcException.*;
import ru.nsu.ccfit.violin.factory.OperationFactory;
import ru.nsu.ccfit.violin.operation.Operation;
import ru.nsu.ccfit.violin.parser.CommandParser;
import ru.nsu.ccfit.violin.calculator.CalculatorDouble;
import ru.nsu.ccfit.violin.calculator.Calculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws Exception {
       /*try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("/logging.properties"));
        } catch (IOException e) {
            System.out.println("Logging haven't launched");
            System.out.println(e.getMessage());
        }*/

        try (CommandParser parser = new CommandParser(args)) {
            Calculator<Double> calculator = new CalculatorDouble();
            OperationFactory<Double> factory = new OperationFactory<>();

            //System.out.println("Ready to execute commands!");
            //logger.log(Level.INFO, "Program start");

            while (parser.ready()) {
                String command = parser.nextLine();
                if (parser.exit()){
                    break;
                }
                try {
                    Operation<Double> op = factory.create(command);
                    calculator.execute(op);
                } catch (NoSuchOperation | OperationInstantiationError |
                         NoOperationConstructor | OperationConfigurationError e) {
                    System.out.println(e.getMessage());
                }
            }

            //System.out.println("Shutting down.");
            logger.log(Level.INFO, "Shutting down.");
        } catch (ConfigurationError | FileNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
            //System.out.println(e.getMessage());
        }
    }
}
