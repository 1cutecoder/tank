package tank;

import java.awt.*;
import java.io.Serializable;

/**
 * 类描述
 *
 * @author zcl
 * @Description 游戏物体
 * @Date 2021/12/19 13:33
 */
public abstract class GameObject implements Serializable {
    public int x, y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();

    public abstract int getHeight();
}
