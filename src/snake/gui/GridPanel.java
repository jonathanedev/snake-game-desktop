package snake.gui;

import javax.swing.*;
import java.awt.*;

import snake.game.Grid;
import snake.GUI;

public class GridPanel extends JPanel {
    
    private final Grid grid;
    private final int gridSize;
    private final CellPanel[][] cellPanel;


    public GridPanel(GUI gui) {
        grid = gui.getGame().getGrid();
        gridSize = grid.getSize();
        cellPanel = new CellPanel[gridSize][gridSize];
    }
}
