package spi.java;


import java.util.ServiceLoader;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-14 下午8:14
 */
public class SpiMain {

    public static void main(String[] args) {

        ServiceLoader<HelloService> serviceLoader = ServiceLoader.load(HelloService.class);

        for (HelloService helloService : serviceLoader) {
            helloService.hello("jason");

        }
    }
}
