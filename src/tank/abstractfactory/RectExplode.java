package tank.abstractfactory;

import tank.Audio;
import tank.ResourceMgr;
import tank.TankFrame;

import java.awt.*;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2021/12/18 15:46
 */
public class RectExplode extends BaseExplode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;
    private TankFrame tf = null;
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(() -> {
            Audio audio = new Audio("audio/explode.wav");
            audio.play();
            audio.close();
        }, "a").start();

    }

    @Override
    public void paint(Graphics g) {
        //g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;
        if (step >= 5) {
            tf.explodes.remove(this);
            g.setColor(c);
        }
    }


}
