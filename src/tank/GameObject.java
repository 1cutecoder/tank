package tank;

import java.awt.*;

/**
 * 类描述
 *
 * @author zcl
 * @Description 游戏物体
 * @Date 2021/12/19 13:33
 */
public abstract class GameObject {
    public int x, y;

    public abstract void paint(Graphics g);
}
