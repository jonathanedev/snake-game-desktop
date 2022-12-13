package snake;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import snake.game.Game;
import snake.gui.GridPanel;

public class GUI extends JFrame {

    private Game game;
    private GridPanel gridPanel;

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

        keyBinding();
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
        gridPanel = new GridPanel(this);
        add(gridPanel);
        pack();
    }

    
    private void keyBinding() {
        class KeyBinding extends KeyAdapter {

            private final GUI gui;

            KeyBinding(GUI gui) {
                this.gui = gui;
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) handleMove("n");
                else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) handleMove("s");
                else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) handleMove("w");
                else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) handleMove("e");
            }
        }

        setFocusable(true);
        this.addKeyListener(new KeyBinding(this));
    }

    public void handleMove(String direction) {
        game.move(direction);
        gridPanel.update();
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