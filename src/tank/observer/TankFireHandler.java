package tank.observer;

import tank.Tank;

/**
 * @author zcl
 * @date 2021/12/21 14:11
 */
public class TankFireHandler extends TankFireObserver{
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank tank = e.getSource();
        tank.fire();
        System.out.println("actionOnFire called ");
    }
}
