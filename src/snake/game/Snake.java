package snake.game;

import java.util.ArrayList;

/**
 * {@code snake.game.Snake} is the object used by the player to interact with
 * the grid.
 * 
 * @author jonathane
 */
public class Snake {

    private int[] head;
    private ArrayList<Integer[]> position;

    public Snake(int[] head) {
        this.head = head;
    }

    public int[] getHead() {
        return head;
    }

    public void setHead(int[] position) {
        head = position;
    }

    public void addPosition(Integer[] position) {
        this.position.add(position);
    }

    public void removePosition() {
        position.remove(position.size()-1);
    }
}
