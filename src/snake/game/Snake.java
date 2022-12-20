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
    private String direction = "e";

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

    public int getLength() {
        return position.size();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if ((this.direction.equals("e") && direction.equals("w")) || (this.direction.equals("w") && direction.equals("e")) || (this.direction.equals("n") && direction.equals("s")) || (this.direction.equals("s") && direction.equals("n"))) return;
        else this.direction = direction;
    }
}
