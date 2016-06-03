package designMode.proxy.staticProxy;

/**
 * Created by jason on 16/6/3.
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("real subject");
    }
}
