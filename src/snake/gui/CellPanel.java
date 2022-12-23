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

        Border greenline = BorderFactory.createLineBorder(new Color(5, 171, 5));
        setBorder(greenline);
        refresh();
    }

    private Color getColour() {
        if (cell.getSnake()) return new Color(255, 153, 0);
        if (cell.getApple()) return Color.RED;
        return new Color(0, 153, 5);
    }

    public void refresh() {
        setBackground(getColour());
    }
}
