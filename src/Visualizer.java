package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Visualizer {
    public Visualizer() {
        JFrame f = new JFrame("title");
        JPanel mainPanel = new JPanel();
        JPanel mazePanel = new JPanel();

        MazeComponent mazeComponent = new MazeComponent();
        mazePanel.add(mazeComponent);
        
        JButton testButton = new JButton("test");
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mazeComponent.drawOperation("test123");
            }
        });
        mainPanel.add(testButton);

        f.add(mazePanel,BorderLayout.CENTER);
        f.add(mainPanel,BorderLayout.LINE_END);
        mainPanel.setPreferredSize(new Dimension(500,100));

        f.setResizable(true);
        f.pack();
        f.setVisible(true);
        f.setPreferredSize(new Dimension(350, 180));
    }
}