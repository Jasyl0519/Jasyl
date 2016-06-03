package designMode.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by jason on 16/6/3.
 */
public class TestDynProxy {

    public static void main(String[] args) {

        RealSubject rs = new RealSubject();

        InvocationHandler handler = new DynamicSubject(rs);

        Class cls = rs.getClass();

        //以下是一次性生成
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        subject.request();


    }
}
