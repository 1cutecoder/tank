package tank;


import java.awt.*;

/**
 * @author zcl
 * @date 2021/12/14 14:02
 */
public class Explode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;
    private TankFrame tf = null;
    public GameModel gm;
    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        new Thread(() -> {
            Audio audio = new Audio("audio/explode.wav");
            audio.play();
            audio.close();
        }, "a").start();

    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            step = 0;
            gm.explodes.remove(this);
        }
    }


}
