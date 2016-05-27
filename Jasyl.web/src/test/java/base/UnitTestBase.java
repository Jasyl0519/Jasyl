package base;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * Created by jason on 16/5/26.
 */
public class UnitTestBase {

    private ClassPathXmlApplicationContext context;

    private String springXmlPath;

    public UnitTestBase(){

    }

    public UnitTestBase(String springXmlPath){
        System.out.println("UnitTestBase");

        this.springXmlPath = springXmlPath;
    }

    @Before
    public void before(){
        System.out.println("before");
        if (StringUtils.isEmpty(springXmlPath)){
            springXmlPath = "classpath*:spring-*.xml";
        }

        try {
            context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        System.out.println("after");
        context.destroy();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId){
        System.out.println("get bean");

        return (T)context.getBean(beanId);
    }

    protected <T extends Object> T getBean(Class<T> clazz){
        return context.getBean(clazz);

    }
}
