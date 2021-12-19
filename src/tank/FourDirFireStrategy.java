package tank;

/**
 * 类描述
 *
 * @author zcl
 * @Description TODO
 * @Date 2021/12/18 14:27
 */
public class FourDirFireStrategy  implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bx = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        for (Dir dir : Dir.values()) {
            t.tf.bullets.add(new Bullet(bx, by, dir, t.group, t.tf));
        }
    }
}
