package src;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

public class MazeComponent extends Component {
    /**
     *
     */
    private static final long serialVersionUID = 3712257156008500629L;

    public Dimension getPreferredSize() {
        return new Dimension(101, 101);
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, 100, 100);
        g.drawString("test", 20, 20);
    }
}