package src.MazeGeneration;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import src.MazeComponent;

public class DepthFirstSearch {
    public static void generate(src.MazeComponent mazeComponent) {
        // Start at top left.
        int r = 1;
        int c = 1;

        boolean[][] maze = new boolean[mazeComponent.getNumSquares()][mazeComponent.getNumSquares()];
        // Initialize, true means it is a wall.
        for (int i = 0; i < mazeComponent.getNumSquares(); i++)
            Arrays.fill(maze[i], true);

        maze[r][c] = false;
        mazeComponent.drawSquare(Color.WHITE, new int[]{r}, new int[]{c});
        generateMazeHelper(r, c, maze, mazeComponent);
        mazeComponent.startTimer();
    }

    private static void generateMazeHelper(int r, int c, boolean[][] maze, MazeComponent mazeComponent) {

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
                        generateMazeHelper(r - 2, c, maze, mazeComponent);
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

                        generateMazeHelper(r, c + 2, maze, mazeComponent);
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

                        generateMazeHelper(r + 2, c, maze, mazeComponent);
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

                        generateMazeHelper(r, c - 2, maze, mazeComponent);
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
    private static Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);

        return randoms.toArray(new Integer[4]);
    }
}
