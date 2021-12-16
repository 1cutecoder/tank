package tank;

import java.awt.*;

/**
 * @author zcl
 * @date 2021/12/14 14:02
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tf = null;
    public static int WIDTH = ResourceMgr.tankL.getWidth();
    public static int HEIGHT = ResourceMgr.tankL.getHeight();
    private boolean living = true;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Dir getDir() {
        return dir;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.tanks.remove(this);
            return;
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    public void resetWidthAndHeight() {
        switch (dir) {
            case LEFT:
                WIDTH = ResourceMgr.tankL.getWidth();
                HEIGHT = ResourceMgr.tankL.getHeight();
                Bullet.WIDTH = ResourceMgr.bulletL.getWidth();
                Bullet.HEIGHT = ResourceMgr.bulletL.getHeight();
                break;
            case UP:
                WIDTH = ResourceMgr.tankU.getWidth();
                HEIGHT = ResourceMgr.tankU.getHeight();
                Bullet.WIDTH = ResourceMgr.bulletU.getWidth();
                Bullet.HEIGHT = ResourceMgr.bulletU.getHeight();
                break;
            case RIGHT:
                WIDTH = ResourceMgr.tankR.getWidth();
                HEIGHT = ResourceMgr.tankR.getHeight();
                Bullet.WIDTH = ResourceMgr.bulletR.getWidth();
                Bullet.HEIGHT = ResourceMgr.bulletR.getHeight();
                break;
            case DOWN:
                WIDTH = ResourceMgr.tankD.getWidth();
                HEIGHT = ResourceMgr.tankD.getHeight();
                Bullet.WIDTH = ResourceMgr.bulletD.getWidth();
                Bullet.HEIGHT = ResourceMgr.bulletD.getHeight();
                break;
            default:
                break;
        }
    }

    private void move() {
        if (!moving) {
            return;
        }
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

    public void fire() {
        resetWidthAndHeight();
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bx, by, this.dir, this.tf));
    }

    public void die() {
        this.living = false;
    }
}
