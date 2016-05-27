package spring.ioc.impl;


import spring.ioc.OneInterface;

/**
 * Created by jason on 16/5/26.
 */
public class OneInterfaceImpl implements OneInterface {

    public String helloWorld(String value) {

        return "hello " + value;
    }
}
