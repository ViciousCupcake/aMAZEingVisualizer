package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class Visualizer {
    public Visualizer() {
        // button list: start/stop x 2, exit, clear, jcombobox dropdown box algorithm
        // choose, log box
        JFrame f = new JFrame("aMAZEing Visualizer");
        JPanel mainPanel = new JPanel();
        JPanel mazePanel = new JPanel();

        MazeComponent mazeComponent = new MazeComponent();
        mazePanel.add(mazeComponent);
        mazePanel.setBorder(BorderFactory.createTitledBorder("Maze Display"));
 

        JButton testButton = new JButton("test");
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // mazeComponent.drawOperation("test123");
                testMazeComponent(mazeComponent);
            }
        });
        mainPanel.add(testButton);

        JButton exitButton = new JButton("exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(f.getSize());
                f.dispose();
            }
        });
        mainPanel.add(exitButton);

        f.add(mazePanel, BorderLayout.LINE_START);
        f.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setPreferredSize(new Dimension(250, 500));

        f.setResizable(false);
        f.pack();
        f.setVisible(true);
    }

    public void testMazeComponent(MazeComponent mazeComponent) {
        System.out.println(mazeComponent);
        for (int a = 0; a < 25; a++) {
            for (int b = 0; b < 25; b++) {
                Color temp = new Color((int) (Math.random() * 256), (int) (Math.random() * 256),
                        (int) (Math.random() * 256));
                mazeComponent.drawSquare(temp, new int[] {a}, new int[] {b});
            }
        }
        mazeComponent.startTimer();
    }
}