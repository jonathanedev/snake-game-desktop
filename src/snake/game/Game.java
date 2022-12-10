package snake.game;

/**
 * {@code snake.game.Game} holds the grid object and provides the interaction
 * between the GUI and the grid.
 * With each game we create a new board, which has a default size).
 * 
 * @author jonathane
 */
public class Game {

    private static final int DEFAULT_GRID_SIZE = 25;

    private final Grid grid;

    public Game() {
        this(DEFAULT_GRID_SIZE);
    }

    public Game(int gridSize) {
        grid = new Grid(gridSize);
    }
}
