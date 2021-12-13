package tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author zcl
 * @date 2021/12/13 14:13
 */
public class TankFrame extends Frame {
    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("Tank War 1");
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
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint called");
        g.fillRect(200, 200, 50, 50);
    }
}
