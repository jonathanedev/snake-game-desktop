package snake.game;

/**
 * {@code snake.game.Cell} holds the cell state snake (determined by whether the
 * snake is at the cell position), and determines the colour shown on the GUI.
 * 
 * @author jonathane
 */
public class Cell {
    private boolean snake = false;

    public boolean getSnake() {
        return snake;
    }

    public void setSnake(boolean snake) {
        this.snake = snake;
    }
}
