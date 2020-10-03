package src;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    MazeComponent mazeComponent;
    JTextArea nestedTextArea;

    public Visualizer() {
        // button list: start/stop x 2, exit, clear, jcombobox dropdown box algorithm
        // choose, log box
        JFrame f = new JFrame("aMAZEing Visualizer");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        CardLayout cardLayout = new CardLayout();
        JPanel mazePanel = new JPanel(cardLayout);

        nestedTextArea = new JTextArea(5, 20);
        nestedTextArea.setLineWrap(true);
        nestedTextArea.setEditable(false);

        mazeComponent = new MazeComponent(nestedTextArea, 15);
        mazePanel.add(mazeComponent);
        cardLayout.next(mazePanel);
        mazePanel.setBorder(BorderFactory.createTitledBorder("Maze Display"));

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
                // nestedtextarea.append starting generation

            }
        });
        JButton mazeGenerationStopButton = new JButton("Stop");
        mazeGenerationStartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // nestedtextarea.append stopping generation

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
                // nestedtextarea.append starting solver
            }
        });
        JButton mazeSolverStopButton = new JButton("Stop");
        mazeSolverStopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // nestedtextarea.append stopping solver

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

        JScrollPane miscLogScrollPane = new JScrollPane(nestedTextArea);

        // miscLogScrollPane.setPreferredSize(new Dimension(200,100));
        miscSubpanel3.add(miscLogLabel);
        miscSubpanel4.add(miscLogScrollPane);

        miscPanel.setBorder(BorderFactory.createTitledBorder("Miscellaneous"));
        JButton testButton = new JButton("Test");
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // testMazeComponent(mazeComponent);
                DFSMazeGeneration(mazeComponent);
            }
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearMaze(mazePanel, cardLayout, true);
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        miscSubpanel5.add(testButton);
        miscSubpanel5.add(clearButton);
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

    public void DFSMazeGeneration(MazeComponent mazeComponent) {
        // Start at top left.
        int r = 1;
        int c = 1;

        boolean[][] maze = new boolean[mazeComponent.getNumSquares()][mazeComponent.getNumSquares()];
        // Initialize, true means it is a wall.
        for (int i = 0; i < mazeComponent.getNumSquares(); i++)
            Arrays.fill(maze[i], true);

        maze[r][c] = false;
        mazeComponent.drawSquare(Color.WHITE, new int[]{r}, new int[]{c});
        DFSMazeGenerationHelper(r, c, maze, mazeComponent);
        mazeComponent.startTimer();
    }

    private void DFSMazeGenerationHelper(int r, int c, boolean[][] maze, MazeComponent mazeComponent) {

        // 4 random directions
        Integer[] randDirs = generateRandomDirections();
        // Examine each direction
        for (int i = 0; i < randDirs.length; i++) {
            switch (randDirs[i]) {
                case 1: // Up
                    // Whether 2 cells up is out or not
                    if (r - 2 <= 0)
                        continue;
                    if (maze[r - 2][c] != false) {
                        maze[r - 2][c] = false;
                        maze[r - 1][c] = false;
                        mazeComponent.drawSquare(Color.WHITE, new int[] { r - 2, r - 1 }, new int[] { c, c });
                        DFSMazeGenerationHelper(r - 2, c, maze, mazeComponent);
                    }
                    break;
                case 2: // Right
                    // Whether 2 cells to the right is out or not
                    if (c + 2 >= maze.length - 1)
                        continue;
                    if (maze[r][c + 2] != false) {
                        maze[r][c + 2] = false;
                        maze[r][c + 1] = false;
                        mazeComponent.drawSquare(Color.WHITE, new int[] { r, r }, new int[] { c + 2, c + 1 });

                        DFSMazeGenerationHelper(r, c + 2, maze, mazeComponent);
                    }
                    break;
                case 3: // Down
                    // Whether 2 cells down is out or not
                    if (r + 2 >= maze.length - 1)
                        continue;
                    if (maze[r + 2][c] != false) {
                        maze[r + 2][c] = false;
                        maze[r + 1][c] = false;
                        mazeComponent.drawSquare(Color.WHITE, new int[] { r + 2, r + 1 }, new int[] { c, c });

                        DFSMazeGenerationHelper(r + 2, c, maze, mazeComponent);
                    }
                    break;
                case 4: // Left
                    // Whether 2 cells to the left is out or not
                    if (c - 2 <= 0)
                        continue;
                    if (maze[r][c - 2] != false) {
                        maze[r][c - 2] = false;
                        maze[r][c - 1] = false;
                        mazeComponent.drawSquare(Color.WHITE, new int[] { r, r }, new int[] { c - 2, c - 1 });

                        DFSMazeGenerationHelper(r, c - 2, maze, mazeComponent);
                    }
                    break;
            }
        }

    }

    /**
     * Generate an array with random directions 1-4
     * 
     * @return Array containing 4 directions in random order
     */
    public Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);

        return randoms.toArray(new Integer[4]);
    }

    private void clearMaze(JPanel parent, CardLayout cardLayout, boolean log) {
        MazeComponent temp = new MazeComponent(nestedTextArea, mazeComponent.getTimerDelay());
        parent.add(temp);
        parent.remove(mazeComponent);
        cardLayout.next(parent);
        mazeComponent.stopTimer();
        mazeComponent = temp;
        if (log)
            logClearedMaze();
    }

    private void logClearedMaze() {
        nestedTextArea.append("Cleared Maze\n");
    }
}