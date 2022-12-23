package snake.gui;

import java.util.Optional;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import snake.GUI;
import snake.game.Game;

public class MenuBar extends JMenuBar {

    public MenuBar(GUI gui) {
        super();
        setVisible(true);

        add(new OptionsMenu(gui));
    }

    private class OptionsMenu extends JMenu {

        private final GUI gui;
        private final JMenuItem newGame;
        private final JMenuItem scoreBoard;
        private final JMenuItem help;
    
        OptionsMenu(GUI gui) {
            super("☰ Menu");
            this.gui = gui;
            setVisible(true);

            newGame = new JMenuItem("New Game");
            scoreBoard = new JMenuItem("Scoreboard");
            help = new JMenuItem("Help");
            add(newGame);
            add(scoreBoard);
            add(help);
            newGame.addActionListener(e -> handleNew());
            scoreBoard.addActionListener(e -> handleScoreBoard());
            help.addActionListener(e -> handleHelp());
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
    
        private void handleScoreBoard() {
            int[] scores = gui.getScores();
            String msg = "";
            for (int i=1; i<=scores.length; i++) {
                msg += "" + i + "  ................................  " + scores[i-1];
                msg += "\n";
            }
            JOptionPane.showMessageDialog(gui, msg, "Highest Scores", JOptionPane.INFORMATION_MESSAGE);
        }

        private void handleHelp() {

        }
    }
}
