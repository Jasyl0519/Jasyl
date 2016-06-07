package designMode.proxy.dynamicProxy.cglib;

/**
 * Created by jason on 16/6/7.
 */
public class TestCglib {

    public static void main(String[] args) {

        CglibDynamicProxy proxy = new CglibDynamicProxy();
        CglibRealSubject realSubject = (CglibRealSubject)proxy.getProxyInstance(new CglibRealSubject());
        realSubject.visit();


    }
}
