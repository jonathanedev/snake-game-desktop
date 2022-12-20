package snake.gui;

import javax.swing.*;
import java.awt.*;

import snake.game.Board;
import snake.game.Cell;
import snake.game.Game;
import snake.GUI;

public class BoardPanel extends JPanel {
    
    private Board board;
    private final int boardSize;
    private final CellPanel[][] grid;


    public BoardPanel(GUI gui) {
        super(new GridLayout(Game.DEFAULT_BOARD_SIZE, Game.DEFAULT_BOARD_SIZE));
        Dimension panelSize = new Dimension(gui.getBoardPanelSize(), gui.getBoardPanelSize());
        setPreferredSize(panelSize);

        boardSize = Game.DEFAULT_BOARD_SIZE;
        grid = new CellPanel[boardSize][boardSize];
        initEmptyGridPanel();
    }

    public BoardPanel(GUI gui, Game game) {
        super(new GridLayout(game.getBoard().getBoardSize(), game.getBoard().getBoardSize()));
        Dimension panelSize = new Dimension(gui.getBoardPanelSize(), gui.getBoardPanelSize());
        setPreferredSize(panelSize);

        board = game.getBoard();
        boardSize = game.getBoard().getBoardSize();
        grid = new CellPanel[boardSize][boardSize];
        initGridPanel();
    }

    private void initEmptyGridPanel() {
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                grid[i][j] = new CellPanel(new Cell());
                this.add(grid[i][j]);
            }
        }
    }

    private void initGridPanel() {
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                grid[i][j] = new CellPanel(board.getCell(i,j));
                this.add(grid[i][j]);
            }
        }
    }

    public void update() {
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                grid[i][j].refresh();
            }
        }
    }
}
