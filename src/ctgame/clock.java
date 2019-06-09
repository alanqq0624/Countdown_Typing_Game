package ctgame;

import javax.swing.*;
import java.awt.*;

public class clock {
    public clock() {
        // FASHION windows(?)
        //JFrame.setDefaultLookAndFeelDecorated(true);

        // create and set windows
        JFrame frame = new JFrame("Countdown Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        // add "Hello World" Jlabel
        JLabel label = new JLabel("TIC TOK TIC TOK");
        JCheckBox checkbox = new JCheckBox("JCheckBox");
        JRadioButton radiobutton = new JRadioButton("JRadiobutton");
        JButton button = new JButton("JButton");
        JTextArea textarea = new JTextArea("JTextArea");
         
        frame.getContentPane().add(BorderLayout.CENTER, label);
        frame.getContentPane().add(BorderLayout.EAST, checkbox);
        frame.getContentPane().add(BorderLayout.WEST, radiobutton);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.NORTH, textarea);

        // show windows
        frame.setVisible(true);
    }
    
}