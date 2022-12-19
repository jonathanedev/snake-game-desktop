package snake.game;

import java.util.ArrayList;

/**
 * {@code snake.game.Snake} is the object used by the player to interact with
 * the grid.
 * 
 * @author jonathane
 */
public class Snake {

    private ArrayList<Integer[]> position = new ArrayList<>();

    public Integer[] getHead() {
        return position.get(position.size()-1);
    }

    public Integer[] getPosition(int index) {
        return position.get(index);
    }

    public void addPosition(Integer[] position) {
        this.position.add(position);
    }

    public void removePosition() {
        position.remove(0);
    }
}
