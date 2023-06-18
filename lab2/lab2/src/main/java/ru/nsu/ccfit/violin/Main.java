package ru.nsu.ccfit.violin;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import ru.nsu.ccfit.violin.controller.CommandTetris;
import ru.nsu.ccfit.violin.controller.Controller;
import ru.nsu.ccfit.violin.controller.TetrisController;

import ru.nsu.ccfit.violin.model.Tetris;
import com.googlecode.lanterna.*;

import ru.nsu.ccfit.violin.viewer.View;
import ru.nsu.ccfit.violin.viewer.cui.ConsoleUI;
import ru.nsu.ccfit.violin.viewer.gui.GraphicUI;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tetris game = new Tetris();
        Controller controller = new TetrisController(game);
        View ui = null;

        StartBy start = StartBy.SWING;
        switch(start){
            case CONSOLE -> ui = new ConsoleUI(controller, game);
            case SWING -> ui = new GraphicUI(controller, game);
        }

        game.attach(ui);
        while (ui.getState() != Thread.State.WAITING || game.getState() != Thread.State.WAITING) {
            Thread.sleep(500);
        }

        controller.execute(CommandTetris.Launch);
    }


    private enum StartBy{
        CONSOLE,
        SWING
    }
}
