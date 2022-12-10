package snake.game;

import java.util.concurrent.ThreadLocalRandom;

public class Grid {
 
    private int size;
    private Cell[][] grid;
    private Snake snake;

    public Grid(int size) {
        this.size = size;
        grid = new Cell[size][size];

        snake = new Snake();
        placeSnake(generateRandomPosition());
    }

    private void placeSnake(int[] position) {
        snake.setPosition(position);
        getCell(position).setSnake(true);
    }

    private int[] generateRandomPosition() {
        int[] position = new int[2];
        position[0] = ThreadLocalRandom.current().nextInt(0, size + 1);
        position[1] = ThreadLocalRandom.current().nextInt(0, size + 1);

        return position;
    }

    public Cell getCell(int[] position) {
        return grid[position[0]][position[1]];
    }
}
