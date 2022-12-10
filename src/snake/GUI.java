package snake;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        setTitle("Snake");
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Error loading cross-platform look and feel"); 
            e.printStackTrace();
            System.exit(1);  
        }
    }
}