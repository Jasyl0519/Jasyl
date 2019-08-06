package abstractclass;

/**
 * Description:
 * Author: lingyou
 * date: 2019-04-10 23:03
 */
public class Test {

    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public String hello() {
                System.out.println("hello, 111");
                return "111";
            }
        };

        abstractClass.hello();

    }
}
