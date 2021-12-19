package tank;


import java.awt.*;

/**
 * @author zcl
 * @date 2021/12/14 14:02
 */
public class Explode extends GameObject{
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    public GameModel gm;
    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        super.x = x;
        super.y = y;
        this.gm = gm;
        new Thread(() -> {
            Audio audio = new Audio("audio/explode.wav");
            audio.play();
            audio.close();
        }, "a").start();

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            step = 0;
            gm.remove(this);
        }
    }


}
