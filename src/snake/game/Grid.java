package snake.game;

import java.util.concurrent.ThreadLocalRandom;

/**
 * {@code snake.game.Grid} holds that 2D array of {@link snake.game.Cell} and
 * uses user input to move the snake around.
 * 
 * @author jonathane
 */
public class Grid {

    private int gridSize;
    private Cell[][] grid;
    private Snake snake;

    public Grid(int size) {
        gridSize = size;
        grid = new Cell[size][size];
        initGrid();

        snake = new Snake();
        placeSnake(generateRandomPosition());
    }

    private void initGrid() {
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void placeSnake(int[] position) {
        snake.setPosition(position);
        getCell(position).setSnake(true);
    }

    private int[] generateRandomPosition() {
        int[] position = new int[2];
        position[0] = ThreadLocalRandom.current().nextInt(0, gridSize + 1);
        position[1] = ThreadLocalRandom.current().nextInt(0, gridSize + 1);
        return position;
    }

    public Cell getCell(int[] position) {
        return grid[position[0]][position[1]];
    }

    public Cell getCell(int i, int j) {
        return grid[i][j];
    }

    public int getGridSize() {
        return gridSize;
    }
}
