package tank.observer;

import tank.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;

/**
 * @author zcl
 * @date 2021/12/21 14:08
 */
public class TankFireEvent {
    Tank tank;

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }

    public Tank getSource(){
        return tank;
    }

}
