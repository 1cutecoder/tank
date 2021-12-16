package tank;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zcl
 * @date 2021/12/13 14:25
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        //初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + i * 80,200,Dir.DOWN,tf));
        }
        while (true) {
            try {TimeUnit.MILLISECONDS.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}
            tf.repaint();
        }
    }

}
