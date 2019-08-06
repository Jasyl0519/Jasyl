package designMode.Observers;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-02-24 下午5:07
 */
public class Client {


    public static void main(String[] args) {

        Stock s = new Stock();

        Person p = new Person(s, "jason ");
        Person p1 = new Person(s, "jason1 ");

        s.setPrice(100);
        s.setPrice(200);

    }
}
