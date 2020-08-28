package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Visualizer {
    public Visualizer() {
        // button list: start/stop x 2, exit, clear, jcombobox dropdown box algorithm
        // choose, log box
        JFrame f = new JFrame("aMAZEing Visualizer");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel mazePanel = new JPanel();

        MazeComponent mazeComponent = new MazeComponent();
        mazePanel.add(mazeComponent);
        mazePanel.setBorder(BorderFactory.createTitledBorder("Maze Display"));

        JButton testButton = new JButton("test");
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testMazeComponent(mazeComponent);
            }
        });

        JButton exitButton = new JButton("exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(f.getSize());
                f.dispose();
            }
        });

        JPanel mazeGenerationPanel = new JPanel(new BorderLayout());
        JPanel mazeGenerationSubpanel1 = new JPanel();
        JPanel mazeGenerationSubpanel2 = new JPanel();
        mazeGenerationSubpanel1.setPreferredSize(new Dimension(mazeGenerationSubpanel1.getPreferredSize().width, 60));
        mazeGenerationPanel.setBorder(BorderFactory.createTitledBorder("Maze Generation"));
        JLabel generationAlgorithmLabel = new JLabel("Algorithm to use:");
        mazeGenerationSubpanel1.add(generationAlgorithmLabel);
        JComboBox<String> generationAlgorithmComboBox = new JComboBox<String>(new String[] {});
        generationAlgorithmComboBox
                .setPreferredSize(new Dimension(200, generationAlgorithmComboBox.getPreferredSize().height));
        // replaceAll("(.)([A-Z])", "$1 $2")
        mazeGenerationSubpanel1.add(generationAlgorithmComboBox);
        JButton mazeGenerationStartButton = new JButton("Start");
        mazeGenerationStartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        JButton mazeGenerationStopButton = new JButton("Stop");
        mazeGenerationStartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        mazeGenerationSubpanel2.add(mazeGenerationStartButton);
        mazeGenerationSubpanel2.add(mazeGenerationStopButton);
        mazeGenerationPanel.add(mazeGenerationSubpanel1, BorderLayout.PAGE_START);
        mazeGenerationPanel.add(mazeGenerationSubpanel2, BorderLayout.PAGE_END);
        mainPanel.add(mazeGenerationPanel);

        JPanel mazeSolverPanel = new JPanel(new BorderLayout());
        JPanel mazeSolverSubpanel1 = new JPanel();
        JPanel mazeSolverSubpanel2 = new JPanel();
        mazeSolverSubpanel1.setPreferredSize(new Dimension(mazeSolverSubpanel1.getPreferredSize().width, 60));
        mazeSolverPanel.setBorder(BorderFactory.createTitledBorder("Maze Solver"));
        JLabel solverAlgorithmLabel = new JLabel("Algorithm to use:");
        mazeSolverSubpanel1.add(solverAlgorithmLabel);
        JComboBox<String> solverAlgorithmComboBox = new JComboBox<String>(new String[] {});
        solverAlgorithmComboBox.setPreferredSize(new Dimension(200, solverAlgorithmComboBox.getPreferredSize().height));
        // replaceAll("(.)([A-Z])", "$1 $2")
        mazeSolverSubpanel1.add(solverAlgorithmComboBox);
        JButton mazeSolverStartButton = new JButton("Start");
        mazeSolverStartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        JButton mazeSolverStopButton = new JButton("Stop");
        mazeSolverStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        mazeSolverSubpanel2.add(mazeSolverStartButton);
        mazeSolverSubpanel2.add(mazeSolverStopButton);
        mazeSolverPanel.add(mazeSolverSubpanel1, BorderLayout.PAGE_START);
        mazeSolverPanel.add(mazeSolverSubpanel2, BorderLayout.PAGE_END);
        mainPanel.add(mazeSolverPanel);

        JPanel miscPanel = new JPanel();
        miscPanel.setLayout(new BoxLayout(miscPanel, BoxLayout.Y_AXIS));
        JPanel miscSubpanel1 = new JPanel();
        JPanel miscSubpanel2 = new JPanel();
        JPanel miscSubpanel3 = new JPanel();
        JPanel miscSubpanel4 = new JPanel();
        JPanel miscSubpanel5 = new JPanel();
        JLabel miscLogLabel = new JLabel("Log:");
        JLabel miscSpeedLabel = new JLabel("Speed (ms): " + mazeComponent.getTimerDelay());
        miscSubpanel1.add(miscSpeedLabel);
        JScrollBar miscSpeedScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, mazeComponent.getTimerDelay(), 100, 10,
                1100);
        miscSpeedScrollBar.setPreferredSize(new Dimension(200, miscSpeedScrollBar.getPreferredSize().height));
        miscSpeedScrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                mazeComponent.setTimerDelay(e.getValue());
                miscSpeedLabel.setText("Speed (ms): " + mazeComponent.getTimerDelay());
            }
        });
        miscSubpanel2.add(miscSpeedScrollBar);
        JTextArea nestedTextArea = new JTextArea(5, 20);
        nestedTextArea.setLineWrap(true);
        nestedTextArea.setEditable(false);
        JScrollPane miscLogScrollPane = new JScrollPane(nestedTextArea);

        // miscLogScrollPane.setPreferredSize(new Dimension(200,100));
        miscSubpanel3.add(miscLogLabel);
        miscSubpanel4.add(miscLogScrollPane);

        miscPanel.setBorder(BorderFactory.createTitledBorder("Miscellaneous"));
        miscSubpanel5.add(testButton);
        miscSubpanel5.add(exitButton);
        miscPanel.add(miscSubpanel1);
        miscPanel.add(miscSubpanel2);
        miscPanel.add(miscSubpanel3);
        miscPanel.add(miscSubpanel4);
        miscPanel.add(miscSubpanel5);
        mainPanel.add(miscPanel);

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
                mazeComponent.drawSquare(temp, new int[] { a }, new int[] { b });
            }
        }
        mazeComponent.startTimer();
    }
}