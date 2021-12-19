package tank.abstractfactory;

import tank.Dir;
import tank.Group;
import tank.TankFrame;

/**
 * 类描述 生产一系列，一定是抽象工厂
 *
 * @author zcl
 * @Description TODO
 * @Date 2021/12/18 15:20
 */
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
}
