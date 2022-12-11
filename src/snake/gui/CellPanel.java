package snake.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import snake.game.Cell;

public class CellPanel extends JPanel {
    
    private Cell cell;

    public CellPanel(Cell cell) {
        this.cell = cell;

        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        setBackground(getColour());
        setBorder(blackLine);
    }

    private Color getColour() {
        if (cell.getSnake()) return new Color(255, 153, 0);
        return new Color(0, 153, 5);
    }
}
