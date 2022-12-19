package snake.gui;

import javax.swing.*;
import java.awt.*;

import snake.game.Board;
import snake.GUI;

public class GridPanel extends JPanel {
    
    private final Board grid;
    private final int gridSize;
    private final CellPanel[][] cellPanel;


    public GridPanel(GUI gui) {
        super(new GridLayout(gui.getGame().getGrid().getGridSize(), gui.getGame().getGrid().getGridSize()));
        Dimension panelSize = new Dimension(gui.getGridPanelSize(), gui.getGridPanelSize());
        setPreferredSize(panelSize);

        grid = gui.getGame().getGrid();
        gridSize = grid.getGridSize();
        cellPanel = new CellPanel[gridSize][gridSize];
        initCellPanel();
    }

    private void initCellPanel() {
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                cellPanel[i][j] = new CellPanel(grid.getCell(i,j));
                this.add(cellPanel[i][j]);
            }
        }
    }

    public void update() {
        for (int i=0; i<gridSize; i++) {
            for (int j=0; j<gridSize; j++) {
                cellPanel[i][j].refresh();
            }
        }
    }
}
