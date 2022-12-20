package snake.game;

import java.util.concurrent.TimeUnit;

import snake.GUI;

/**
 * {@code snake.game.Game} holds the grid object and provides the interaction
 * between the GUI and the grid.
 * With each game we create a new board, which has a default size).
 * 
 * @author jonathane
 */
public class Game {

    public static final int DEFAULT_BOARD_SIZE = 20;
    private static final int TIME_BETWEEN_UPDATES = 250;

    public Object lock = new Object();
    private GUI gui;
    private final Board board;
    private Runner runner;
    private boolean isPaused = true;

    public Game(GUI gui) {
        this(gui, DEFAULT_BOARD_SIZE);
    }

    public Game(GUI gui, int boardSize) {
        this.gui = gui;
        board = new Board(this, boardSize);

        runner = new Runner();
        Thread thread = new Thread(runner);
        thread.start();
    }

    public void play() {
        isPaused = false;
    }

    public void move() {
        while (!isPaused()) {
            allowPause();
            board.moveSnake();
            gui.update();
            sleep();
        }
    }

    private void allowPause() {
        synchronized (lock) {
            while (isPaused()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }
    }

    private void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(TIME_BETWEEN_UPDATES);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public void endGame() {
        isPaused = true;
        runner.end();
        System.out.println("end");
    }

    public Board getBoard() {
        return board;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public Runner getRunner() {
        return runner;
    }

    public class Runner implements Runnable {
        volatile boolean running = true;

        @Override
        public void run() {
            while(running) {
                //System.out.print("d");
                move();
            } 
        }

        public void end() {
            running = false;
        }
    }
}
