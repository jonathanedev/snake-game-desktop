package snake.game;

/**
 * {@code snake.game.Game} holds the grid object and provides the interaction
 * between the GUI and the grid.
 * With each game we create a new board, which has a default size).
 * 
 * @author jonathane
 */
public class Game {

    public static final int DEFAULT_BOARD_SIZE = 25;

    private final Board board;

    public Game() {
        this(DEFAULT_BOARD_SIZE);
    }

    public Game(int boardSize) {
        board = new Board(boardSize);
    }

    public void move(String direction) {
        board.moveSnake(direction);
    }

    public Board getBoard() {
        return board;
    }
}
