package tank.abstractfactory;

import tank.*;

import java.awt.*;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2021/12/18 16:03
 */
public class RectBullet extends BaseBullet {
    private final int SPEED = 10;
    private int x, y;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    Rectangle rect = new Rectangle();
    private Dir dir;
    private boolean living = true;
    public TankFrame tf = null;
    private Group group = Group.BAD;

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 20, 20);
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    @Override
    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {
            return;
        }
        //TODO 用一个rect来记录子弹的位置
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tf.explodes.add(tf.gf.createExplode(eX, eY, this.tf));
        }
    }

    private void die() {
        this.living = false;
    }
}
