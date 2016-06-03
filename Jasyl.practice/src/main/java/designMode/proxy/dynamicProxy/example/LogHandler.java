package designMode.proxy.dynamicProxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jason on 16/6/3.
 */
public class LogHandler implements InvocationHandler {

    private Object object;

    public Object newProxyInstance(Object object){

        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("start-->>" + method.getName());
        for (int i=0; i<args.length; i++) {
            System.out.println(args[i]);
        }

        before();
        method.invoke(object, args);

        after();
        return null;
    }

    private void before(){
        System.out.println("log before... do something");
    }

    private void after(){
        System.out.println("log after... do something");
    }
}
