package designMode.proxy.simpleProxy;

/**
 * Created by jason on 16/6/3.
 */
public class TestProxy {

    public static void main(String[] args) {
        SchoolGirl mm = new SchoolGirl();
        mm.setName("志玲MM");

        Proxy proxy = new Proxy(mm);

        proxy.giveChocolate();

    }
}
