package tank;

import java.awt.*;
import java.util.Random;

/**
 * @author zcl
 * @date 2021/12/14 14:02
 */
public class Explode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;
    private TankFrame tf = null;
    private boolean living = true;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if (step >= ResourceMgr.explodes.length ) {
            step = 0;
        }
    }



}
