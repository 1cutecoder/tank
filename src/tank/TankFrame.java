package tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author zcl
 * @date 2021/12/13 14:13
 */
public class TankFrame extends Frame {
    int x = 200, y = 200;

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("Tank War ");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint called x=" + x + "y=" + y);
        g.fillRect(x, y, 50, 50);
        x += 10;
//        y += 10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            x += 200;
            //repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}
