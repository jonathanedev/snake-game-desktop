package snake;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.Path;

import snake.files.SnakeFileReader;
import snake.files.SnakeFileWriter;
import snake.game.Game;
import snake.gui.BoardPanel;
import snake.gui.MenuBar;

public class GUI extends JFrame {

    private static final String filepath = "./data/score.snake";

    private MenuBar menuBar;
    private Game game;
    private int[] scores;
    private BoardPanel boardPanel;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        setTitle("Snake");
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new MenuBar(this);
        setJMenuBar(menuBar);
        setResizable(false);
        reset(Game.DEFAULT_BOARD_SIZE);
        loadScores();
        setVisible(true);
        keyBinding();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.err.println("Error loading cross-platform look and feel");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void loadScores() {
        scores = SnakeFileReader.read(Path.of(filepath));
    }

    public void updateHighScore(int score) {
        checkHighScore(score);
        SnakeFileWriter.write(Path.of(filepath), scores);
    }

    public void checkHighScore(int score) {        
        int i;
        for(i=0;i<scores.length;i++){
            if(scores[i]<score) break;
        }
        if (i==scores.length) return;
        for(int k=scores.length-2; k>=i; k--){
            scores[k+1]=scores[k];            
        }
        scores[i]=score;
    }

    private void keyBinding() {
        class KeyBinding extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W)
                    handleInput("n");
                else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S)
                    handleInput("s");
                else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A)
                    handleInput("w");
                else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D)
                    handleInput("e");
            }
        }

        setFocusable(true);
        this.addKeyListener(new KeyBinding());
    }

    public void handleInput(String direction) {
        if (game == null)
            return;
        game.getBoard().changeSnakeDirection(direction);
        game.play();
    }

    public void reset(int size) {
        getContentPane().removeAll();
        initGameComponents(size);
        repaint();
    }

    private void initGameComponents(int size) {
        if (game != null)
            game.getRunner().end();

        game = new Game(this, size);
        boardPanel = new BoardPanel(this, game);
        add(boardPanel);
        pack();
    }

    public void update() {
        boardPanel.update();
        menuBar.update();
    }

    public void displayEndGame(int score) {
        String[] title = { "Retry" };
        int n = JOptionPane.showOptionDialog(boardPanel, "Your Score was " + score + "\nWould you like to try again?","Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, title, title[0]);
        
        if (n == 0) reset(game.getBoard().getBoardSize());
    }

    public int getBoardPanelSize() {
        return ((int) (0.7 * getScreenHeight()));
    }

    public int getScreenHeight() {
        return getGraphicsConfiguration().getBounds().height;
    }

    public Game getGame() {
        return game;
    }

    public int[] getScores() {
        return scores;
    }
}