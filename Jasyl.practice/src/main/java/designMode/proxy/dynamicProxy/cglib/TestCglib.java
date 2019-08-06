package designMode.proxy.dynamicProxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * Created by jason on 16/6/7.
 */
public class TestCglib {

    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/jason/IdeaProjects/Jasyl/com/sun/proxy");

        CglibDynamicProxy proxy = new CglibDynamicProxy();
        CglibRealSubject realSubject = (CglibRealSubject)proxy.getProxyInstance(new CglibRealSubject());
        realSubject.visit();


    }
}
