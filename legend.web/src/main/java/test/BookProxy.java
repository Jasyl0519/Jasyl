package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jason on 15/10/9.
 */
public class BookProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target){
        this.target = target;

       Object object = Proxy.newProxyInstance(target.getClass().getClassLoader(),
               target.getClass().getInterfaces(),
               this);

        return object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        System.out.println("---start---");

        result=method.invoke(target, args);

        System.out.println("---end---");

        return result;
    }
}
