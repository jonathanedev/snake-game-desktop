package snake.game;

/**
 * {@code snake.game.Snake} is the object used by the player to interact with
 * the grid.
 * 
 * @author jonathane
 */
public class Snake {
    private int[] position;

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}
