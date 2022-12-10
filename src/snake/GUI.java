package snake;

import javax.swing.*;

import snake.game.Game;
import snake.gui.GridPanel;

import java.awt.*;

public class GUI extends JFrame {

    private Game game;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        game = new Game();

        setTitle("Snake");
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Error loading cross-platform look and feel"); 
            e.printStackTrace();
            System.exit(1);  
        }
    }

    private void initComponents() {
        add(new GridPanel(this));
        pack();
    }

    public int getGridPanelSize() {
        return ((int) (0.7 * getScreenHeight()));
    }

    public int getScreenHeight() {
        return getGraphicsConfiguration().getBounds().height;
    }

    public Game getGame() {
        return game;
    }
}