package snake.gui;

import java.util.Optional;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import snake.GUI;
import snake.game.Game;

public class MenuBar extends JMenuBar {
    
    protected final GUI gui;
    private final JMenuItem newGame;


    public MenuBar(GUI gui) {
        super();
        this.gui = gui;
        setVisible(true);

        newGame = new JMenuItem("New Game");
        add(newGame);
        newGame.addActionListener(e -> handleNew());
    }

    private void handleNew() {
        Optional<Integer> size = selectSize();
        if (size.isPresent()) {
            gui.reset(size.get());
        }
    }

    private Optional<Integer> selectSize() {
        while(true) {
            try {
                String input = JOptionPane.showInputDialog(this, "Board Size:", Game.DEFAULT_BOARD_SIZE);
                if (input == null) return Optional.empty();

                int choice = Integer.parseInt(input);
                if (choice > 5 && choice < 80) return Optional.of(choice);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
    }
}
