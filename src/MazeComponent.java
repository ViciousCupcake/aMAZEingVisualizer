package src;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.Timer;

public class MazeComponent extends Component {
    /**
     *
     */
    private static final long serialVersionUID = 3712257156008500629L;
    private BufferedImage virtualMemory;
    private Graphics g;
    private Timer timer;
    private LinkedList<MazeSquareEntry> entries;
    private double borderWidth = 0.025; // Represented as percentage < 0.5
    private int numSquares = 25; // Must be odd number
    private int timerDelay = 15;

    public MazeComponent() {
        virtualMemory = new BufferedImage(getPreferredSize().width, getPreferredSize().height,
                BufferedImage.TYPE_3BYTE_BGR);
        this.g = virtualMemory.getGraphics();
        entries = new LinkedList<MazeSquareEntry>();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
        g.setColor(Color.BLACK);
        int startX = (int) (getPreferredSize().width * borderWidth);
        int startY = (int) (getPreferredSize().height * borderWidth);
        int width = (int) (getPreferredSize().width - 2 * getPreferredSize().width * borderWidth);
        int height = (int) (getPreferredSize().height - 2 * getPreferredSize().height * borderWidth);
        double squareWidth = width / (double) numSquares;
        double squareHeight = height / (double) numSquares;
        g.fillRect(startX, startY, width, height);
        timer = new Timer(timerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MazeSquareEntry currentEntry = entries.remove();
                g.setColor(currentEntry.getColor());
                for (int a = 0; a < currentEntry.getX().length; a++) {
                    g.fillRect((int) (squareWidth * currentEntry.getX()[a] + startX),
                            (int) (squareHeight * currentEntry.getY()[a] + startY), (int) squareWidth,
                            (int) squareHeight);
                }
                if (entries.isEmpty()) {
                    timer.stop();
                    System.out.println("Stopped timer due to no entries");
                }
                repaint();
            }
        });

    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public void paint(Graphics g) {
        g.drawImage(virtualMemory, 0, 0, this);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void setTimerDelay(int ms) {
        timerDelay = ms;
        timer.setDelay(timerDelay);
    }

    public int getTimerDelay(){
        return timerDelay;
    }

    public void drawSquare(Color c, int[] x, int[] y) {
        entries.add(new MazeSquareEntry(c, x, y));
    }
}