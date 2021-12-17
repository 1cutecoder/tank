package tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author zcl
 * @date 2021/12/14 14:02
 */
public class Tank {
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    public Rectangle rect = new Rectangle();
    private Random random = new Random();
    private int x, y;
    private Dir dir = Dir.DOWN;
    private final int SPEED = 5;
    private boolean moving = true;
    private TankFrame tf = null;
    private boolean living = true;
    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public Group getGroup() {
        return group;
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
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    public void resetWidthAndHeight() {
        switch (dir) {
            case LEFT:
                BufferedImage bufferedImageL = this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL;
                WIDTH = bufferedImageL.getWidth();
                HEIGHT = bufferedImageL.getHeight();
                Bullet.WIDTH = ResourceMgr.bulletL.getWidth();
                Bullet.HEIGHT = ResourceMgr.bulletL.getHeight();
                break;
            case UP:
                BufferedImage bufferedImageU = this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU;
                WIDTH = bufferedImageU.getWidth();
                HEIGHT = bufferedImageU.getHeight();
                Bullet.WIDTH = ResourceMgr.bulletU.getWidth();
                Bullet.HEIGHT = ResourceMgr.bulletU.getHeight();
                break;
            case RIGHT:
                BufferedImage bufferedImagerR = this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR;
                WIDTH = bufferedImagerR.getWidth();
                HEIGHT = bufferedImagerR.getHeight();
                Bullet.WIDTH = ResourceMgr.bulletR.getWidth();
                Bullet.HEIGHT = ResourceMgr.bulletR.getHeight();
                break;
            case DOWN:
                BufferedImage bufferedImagerD = this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD;
                WIDTH = bufferedImagerD.getWidth();
                HEIGHT = bufferedImagerD.getHeight();
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
        resetWidthAndHeight();
        boundsCheck();
        if (Group.BAD.equals(this.group) && random.nextInt(100) > 95) {
            this.fire();
        }
        if (Group.BAD.equals(this.group) && random.nextInt(100) > 95) {
            randomDir();
        }
        if (Group.GOOD.equals(this.group)) {
            new Thread(() -> {
                Audio audio = new Audio("audio/tank_move.wav");
                audio.play();
                audio.close();
            }, "b").start();
        }
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (x < 0) {
            x = 0;
        }
        if (y < HEIGHT / 2) {
            y = HEIGHT / 2;
        }
        if ((x + WIDTH) > TankFrame.GAME_WIDTH) {
            x = TankFrame.GAME_WIDTH - WIDTH;
        }
        if ((y + HEIGHT) > TankFrame.GAME_HEIGHT) {
            y = TankFrame.GAME_HEIGHT - HEIGHT;
        }
    }

    private void randomDir() {
        Dir[] dirs = Dir.values();
        this.dir = dirs[random.nextInt(4)];
    }

    public void fire() {
        resetWidthAndHeight();
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bx, by, this.dir, group, this.tf));
    }

    public void die() {
        this.living = false;
    }
}
