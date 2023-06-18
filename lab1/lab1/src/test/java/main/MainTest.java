package main;

import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.violin.main.Main;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main program;
    @Test
    public void GeneralTest() throws Exception {
        String[] args = {"input1.txt"};
        Main.main(args);
    }
}