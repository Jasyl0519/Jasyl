package Factory;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by jason on 16/5/11.
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        //Resource resource = new ClassPathResource("spring-servlet.xml");

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-servlet.xml"));
        MyTestBean bean = (MyTestBean)bf.getBean("myTestBean");
        String str = bean.getTestStr();
        System.out.println(str);

        Assert.assertEquals("testStr", str);



    }

}
