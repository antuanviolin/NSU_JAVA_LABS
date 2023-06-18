package ru.nsu.ccfit.violin.viewer.gui;

import ru.nsu.ccfit.violin.controller.Controller;
import ru.nsu.ccfit.violin.model.exception.UnattachedObserverException;
import ru.nsu.ccfit.violin.observation.Observer;
import ru.nsu.ccfit.violin.observation.Subject;
import ru.nsu.ccfit.violin.model.Package;
import ru.nsu.ccfit.violin.viewer.View;

import javax.swing.*;

public class GraphicUI extends View {
    private final Subject model;
    private final MainWindow mainWindow;

    @Override
    synchronized public void run() {
        while (!Thread.interrupted()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                break;
            }

            Package pkg;
            try {
                pkg = (Package) model.getInfo(this);
            } catch (UnattachedObserverException e) {
                throw new RuntimeException(e);
            }
            System.out.println(pkg.getState());
            switch(pkg.getState()){
                case defaultState -> mainWindow.updateWindow(pkg);
                case onlyAboutState -> mainWindow.showAbout();
                case onlyScoresState -> mainWindow.showScores(pkg);
                case authState -> mainWindow.askAuth(pkg);
            }

        }
    }

    public GraphicUI(Controller _controller, Subject _subject) throws InterruptedException {
        model = _subject;

        JFrame mainFrame = new JFrame("Tetris");
        mainFrame.setSize(600, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setIconImage(new ImageIcon("resources/images/main_frame_icon.jpg").getImage());

        mainWindow = new MainWindow(_controller, this);

        this.start();
    }

    @Override
    synchronized public void update() {
        this.notifyAll();
    }
}
