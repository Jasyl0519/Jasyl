package designMode.proxy.dynamicProxy;

/**
 * Created by jason on 16/6/3.
 */
public class TestDynProxy {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject rs = new RealSubject();

        DynamicSubject handler = new DynamicSubject(rs);

        //以下是一次性生成
        Subject subject = (Subject) handler.getProxy();
        subject.request();

        System.out.println(rs.getClass().getInterfaces());


    }
}
