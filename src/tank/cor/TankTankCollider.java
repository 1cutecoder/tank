package tank.cor;

import tank.*;

/**
 * 类描述
 *
 * @author zcl
 * @Description 两个坦克相撞
 * @Date 2021/12/19 20:54
 */
public class TankTankCollider implements Collider {

    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (Group.BAD.equals(t1.group) && Group.BAD.equals(t2.group)) {
                if (t1.rect.intersects(t2.rect)) {
                    t1.x = t1.preX;
                    t1.y = t1.preY;
                    t2.x = t2.preX;
                    t2.y = t2.preY;
                }
            }
        }
    }
}
