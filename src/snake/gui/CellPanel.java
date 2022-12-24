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
        refresh();
    }

    private Color getColour() {
        if (cell.getSnake()) return new Color(255, 153, 0);
        if (cell.getApple()) return Color.RED;
        return new Color(0, 153, 5);
    }

    private Border getBorderColour() {
        if (cell.getSnake()) return BorderFactory.createLineBorder(new Color(194, 123, 17));
        if (cell.getApple()) return BorderFactory.createLineBorder(new Color(166, 13, 13));
        return BorderFactory.createLineBorder(new Color(5, 171, 5));
    }

    public void refresh() {
        setBackground(getColour());
        setBorder(getBorderColour());
    }
}
