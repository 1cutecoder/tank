package tank;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2021/12/18 12:38
 */
public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bx = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        t.gm.bullets.add(new Bullet(bx, by, t.getDir(), t.group, t.gm));
    }
}
