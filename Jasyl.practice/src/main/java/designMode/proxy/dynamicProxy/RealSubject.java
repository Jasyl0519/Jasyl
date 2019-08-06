package designMode.proxy.dynamicProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jason on 16/6/3.
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("dynamic proxy real subject...");
    }


    public static void main(String[] args) {
        try {
            Class clz = Class.forName("designMode.proxy.dynamicProxy.RealSubject");
            Object o = clz.newInstance();
            Method method = clz.getMethod("request");

            for (int i = 0; i < 17; i++) {
                method.invoke(o);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
