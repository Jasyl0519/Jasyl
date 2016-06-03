package designMode.proxy.staticProxy;

/**
 * Created by jason on 16/6/3.
 */
public class ProxySubject implements Subject{

    private RealSubject realSubject;

    @Override
    public void request() {

        before();

        if (realSubject == null) {
            realSubject = new RealSubject();
        }

        realSubject.request();

        after();

    }

    public void before(){
        System.out.println("before proxy subject...");
    }

    public void after(){
        System.out.println("after proxy subject...");

    }
}
