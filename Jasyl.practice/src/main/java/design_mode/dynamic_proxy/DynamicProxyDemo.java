package design_mode.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-12-13 下午4:47
 */
public class DynamicProxyDemo implements InvocationHandler {

    private RealGoal realGoal;

    public DynamicProxyDemo(RealGoal realGoal) {
        this.realGoal = realGoal;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("做某事之前....");
        realGoal.doSomething();
        System.out.println("做某事之后....");

        return null;
    }

    public static void main(String[] args) {

        RealGoal realGoal = new RealGoal();
        DynamicProxyDemo dynamicProxyDemo = new DynamicProxyDemo(realGoal);

        Goal goal = (Goal) Proxy.newProxyInstance(realGoal.getClass().getClassLoader(), realGoal.getClass().getInterfaces(),
                dynamicProxyDemo);

        goal.doSomething();


    }
}
