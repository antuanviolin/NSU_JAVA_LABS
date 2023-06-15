package factory;

import ru.nsu.ccfit.violin.calcException.*;
import ru.nsu.ccfit.violin.factory.OperationFactory;
import ru.nsu.ccfit.violin.operation.Operation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationFactoryTest {
    private OperationFactory<Double> factory = null;

    @Test
    void create() throws ConfigurationError, OperationInstantiationError, OperationConfigurationError, NoSuchOperation, NoOperationConstructor {
        try{
            factory = new OperationFactory<>("THIS_FILE_DOEST_EXIST.format");
        } catch (ConfigFileHaventOpened e){
            assertTrue(true);
        }

        factory = new OperationFactory<>();
        String[] unknownParsedString = {"UNKNOWN UNKNOWN UNKNOWN", "UNKNOWN", "int 80", "rm -rf", "", "русский язык"};
        for(String unknownToken : unknownParsedString){
            assertThrowsExactly(NoSuchOperation.class, ()-> factory.create(unknownToken));
        }

        Operation<Double> operation1 = factory.create("/");
        Operation<Double> operation2 = factory.create("/");
        assertEquals(operation1, operation2);

    }
}