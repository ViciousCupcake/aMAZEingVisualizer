package src;

import java.awt.Color;

/**
 * A individual helper object representing a square in the mazeComponent Squares
 * are designed to be immutable, hence no setX() etc. methods
 * 
 * @author Jonathan Xu
 */
public class MazeSquareEntry {
    private Color c;
    private int[] x;
    private int[] y;

    public MazeSquareEntry(Color c, int[] x, int[] y) {
        this.c = c;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return c;
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }
}