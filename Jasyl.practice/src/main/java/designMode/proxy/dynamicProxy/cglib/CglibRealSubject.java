package designMode.proxy.dynamicProxy.cglib;

/**
 * Created by jason on 16/6/7.
 */
public class CglibRealSubject {

    public void visit(){
        System.out.println("I am 'RealSubject',I am the execution method");
    }
}
