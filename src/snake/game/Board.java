package snake.game;

import java.util.concurrent.ThreadLocalRandom;

/**
 * {@code snake.game.Grid} holds that 2D array of {@link snake.game.Cell} and
 * uses user input to move the snake around.
 * 
 * @author jonathane
 */
public class Board {

    private static final int DEFAULT_BOARD_SIZE = 15;
    private static final int DEFAULT_SNAKE_LENGTH = 3;

    private int boardSize;
    private Cell[][] board;
    private Snake snake;

    public Board() {
        this(DEFAULT_BOARD_SIZE);
    }

    public Board(int size) {
        boardSize = size;
        board = new Cell[size][size];
        initBoard();
        generateSnake();
        generateApple();
    }

    /**
     * Creates Cell objects in the 2D array.
     */
    private void initBoard() {
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    /**
     * Adds the snake onto the boards centre position.
     * Positions added to the snake are accessed in the 2D array with snake boolean set true.
     */
    private void generateSnake() {
        snake = new Snake();

        for (int i=DEFAULT_SNAKE_LENGTH; i>0; i--) {
            Integer[] position = { boardSize/2, boardSize/2 -i };
            snake.addPosition(position);
            getCell(position).setSnake(true);
        }
    }

    
    public void moveSnake() {
        String direction = snake.getDirection();
        Integer[] newPosition = getTargetPosition(snake.getHead(), direction);

        if (getCell(newPosition).getApple()) {
            appleCollision(newPosition);
            generateApple();
        } else {
            getCell(snake.getPosition(0)).setSnake(false);
            snake.addPosition(newPosition);
            getCell(newPosition).setSnake(true);
            snake.removePosition();
        }
    }

    private void appleCollision(Integer[] position) {
        snake.addPosition(position);
        getCell(position).setSnake(true);
        getCell(position).setApple(false);
    }

    private Integer[] getTargetPosition(Integer[] position, String direction) {
        Integer[] newPosition = { position[0], position[1] };
        int distance = 1;

        switch (direction) {
            case "n":
                int newRow = newPosition[0] - distance;
                newPosition[0] = newRow;
                break;
            case "e":
                int newCol = newPosition[1] + distance;
                newPosition[1] = newCol;
                break;
            case "s":
                newRow = newPosition[0] + distance;
                newPosition[0] = newRow; 
                break;
            case "w":
                newCol = newPosition[1] - distance;
                newPosition[1] = newCol;
                break;
        }

        return newPosition;
    }

    private void generateApple() {
        boolean placed = false;
        while(!placed) {
            int[] position = generateRandomPosition();
            if (!(getCell(position).getApple() || getCell(position).getSnake())) {
                getCell(position).setApple(true);
                placed = true;
            } 
        }
    }

    private int[] generateRandomPosition() {
        int[] position = new int[2];
        position[0] = ThreadLocalRandom.current().nextInt(0, boardSize);
        position[1] = ThreadLocalRandom.current().nextInt(0, boardSize);
        return position;
    }

    public void changeSnakeDirection(String direction) {
        snake.setDirection(direction);
    }

    public Cell getCell(Integer[] position) {
        return getCell(new int[]{position[0], position[1]});
    }

    public Cell getCell(int[] position) {
        return getCell(position[0], position[1]);
    }

    public Cell getCell(int i, int j) {
        return board[i][j];
    }

    public int getBoardSize() {
        return boardSize;
    }
}
