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
        super(new GridLayout(gui.getGame().getGrid().getGridSize(), gui.getGame().getGrid().getGridSize()));
        Dimension panelSize = new Dimension(gui.getGridPanelSize(), gui.getGridPanelSize());
        setPreferredSize(panelSize);

        grid = gui.getGame().getGrid();
        gridSize = grid.getGridSize();
        cellPanel = new CellPanel[gridSize][gridSize];
    }
}
