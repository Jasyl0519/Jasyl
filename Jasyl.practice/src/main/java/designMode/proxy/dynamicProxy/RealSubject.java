package designMode.proxy.dynamicProxy;

/**
 * Created by jason on 16/6/3.
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("dynamic proxy real subject...");
    }
}
