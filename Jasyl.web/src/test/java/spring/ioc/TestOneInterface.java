package spring.ioc;


import base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by jason on 16/5/26.
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class TestOneInterface extends UnitTestBase{

    public TestOneInterface(){
        super("classpath*:spring-servlet.xml");
    }

    @Test
    public void testHello(){
        System.out.println("testHello");
        //OneInterface oneInterface = super.getBean("oneInterface");
        //String string = oneInterface.helloWorld("world");
        //System.out.println(string);
    }
}
