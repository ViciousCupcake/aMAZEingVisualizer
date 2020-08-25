package src;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.Timer;

public class MazeComponent extends Component {
    /**
     *
     */
    private static final long serialVersionUID = 3712257156008500629L;
    private BufferedImage virtualMemory;
    private Graphics g;
    private String operationMode = "null";
    Timer timer;
    boolean b;
    int index = 20;
    int z = 0;

    public MazeComponent() {
        virtualMemory = new BufferedImage(getPreferredSize().width,getPreferredSize().height,BufferedImage.TYPE_3BYTE_BGR);
        this.g = virtualMemory.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getPreferredSize().width, getPreferredSize().height);
        g.setColor(Color.BLACK);
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                index += 5;
                if (index > 1000)
                    timer.stop();
                //operation mode logic here
                g.drawString("test",20,index);
                repaint();
            }
        });

    }

    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    public void paint(Graphics g) {
        g.drawImage(virtualMemory, 0, 0, this);
    }

    public void drawOperation(String operationMode) {
        /*this.operationMode = operationMode;
        repaint();*/
        timer.start();

    }
}