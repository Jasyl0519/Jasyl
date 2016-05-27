package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jason on 16/5/23.
 */
public class TestBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("test");
    }


    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("aspectTest.xml");
        TestBean tb = (TestBean) ac.getBean("test");
        tb.test();
    }
}
