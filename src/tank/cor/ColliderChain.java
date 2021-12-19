package tank.cor;

import tank.GameObject;
import tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述
 *
 * @author zcl
 * @Description 碰撞责任链类
 * @Date 2021/12/19 21:18
 */
public class ColliderChain implements Collider {
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        String[] colliderStrs = PropertyMgr.getStrings("colliders");
        for (int i = 0; i < colliderStrs.length; i++) {
            try {
                add((Collider) Class.forName(colliderStrs[i]).getDeclaredConstructor().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        int i = 0;
        int j = 1;
    }

    public void add(Collider c) {
        colliders.add(c);
    }


    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            boolean b = colliders.get(i).collide(o1, o2);
            if (b) {
                return true;
            }
        }
        return false;
    }
}
