package src;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Visualizer {
    public Visualizer() {
        JFrame f = new JFrame("title");
        JPanel mainPanel = new JPanel();
        JLabel label = new JLabel("test");
        f.add(mainPanel);
        f.add(label);
        f.setResizable(false);
        f.pack();
        f.setVisible(true);
        f.setPreferredSize(new Dimension(350, 180));
    }
}