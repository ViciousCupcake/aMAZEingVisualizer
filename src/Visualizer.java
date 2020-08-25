package src;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Visualizer {
    public Visualizer() {
        JFrame f = new JFrame("title");
        JPanel mainPanel = new JPanel();
        JPanel mazePanel = new JPanel();

        JLabel label = new JLabel("test");
        mainPanel.add(label);

        mazePanel.add(new MazeComponent());

        f.add(mazePanel,BorderLayout.CENTER);
        f.add(mainPanel,BorderLayout.LINE_END);
        mainPanel.setPreferredSize(new Dimension(500,100));

        f.setResizable(true);
        f.pack();
        f.setVisible(true);
        f.setPreferredSize(new Dimension(350, 180));
    }
}