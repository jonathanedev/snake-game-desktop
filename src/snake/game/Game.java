package snake.game;

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
