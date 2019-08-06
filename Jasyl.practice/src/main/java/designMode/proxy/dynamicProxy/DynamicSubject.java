package designMode.proxy.dynamicProxy;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jason on 16/6/3.
 */
public class DynamicSubject implements InvocationHandler {

    private Object object;


    DynamicSubject(Object object){

        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();

        Object result = method.invoke(object, args);
        System.out.println(JSON.toJSON(result));

        after();


        return result;
    }

    public Object getProxy() {

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                object.getClass().getInterfaces(), this);
        
    }


    public void before(){
        System.out.println("dynamic before");
    }

    public void after(){
        System.out.println("dynamic after");
    }


}
