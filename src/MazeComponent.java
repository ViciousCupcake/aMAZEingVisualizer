package src;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MazeComponent extends Component {
    /**
     *
     */
    private static final long serialVersionUID = 3712257156008500629L;
    private Graphics g;
    private String operationMode = "null";
    Timer timer;
    boolean b;
    int index = 20;

    public MazeComponent() {
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                index+=5;
                if(index>50)
                    timer.stop();
                repaint();
            }
        });

    }

    public Dimension getPreferredSize() {
        return new Dimension(101, 101);
    }

    public void paint(Graphics g) {
        g.drawString("test1", 20, index);
        /*this.g = g;
        g.drawRect(0, 0, 100, 100);
        // test();

        switch (operationMode) {
            case "null":

                break;

            default:
                for (int a = 0; a < 100; a += 10) {
                    g.drawString(operationMode, 20, 20 + a);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("test");
                break;
        }*/

        /*
         * if (!operationMode.equals("null")){ g.drawString(operationMode, 20, 20);
         * System.out.println(2); }
         */
    }

    public void drawOperation(String operationMode) {
        /*this.operationMode = operationMode;
        repaint();*/
        timer.start();

    }
}