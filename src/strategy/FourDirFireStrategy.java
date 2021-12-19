package strategy;

import tank.Bullet;
import tank.Dir;
import tank.Tank;

/**
 * 类描述
 *
 * @author zcl
 * @Description 四个方向打子弹
 * @Date 2021/12/18 14:27
 */
public class FourDirFireStrategy  implements FireStrategy{
    @Override
    public void fire(Tank t) {
        int bx = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        for (Dir dir : Dir.values()) {
            t.gm.add(new Bullet(bx, by, dir, t.group, t.gm));
        }
    }
}
