package tank;

import java.awt.*;

/**
 * @author zcl
 * @date 2021/12/14 14:37
 */
public class Bullet {
    private final int SPEED = 2;
    private int x,y;
    private int width = 30,height = 30;
    private Dir dir;


    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,width,height);
        g.setColor(color);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

}
