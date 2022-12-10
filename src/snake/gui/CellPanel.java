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
        setBackground(Color.CYAN);
        setBorder(blackLine);
    }
}
