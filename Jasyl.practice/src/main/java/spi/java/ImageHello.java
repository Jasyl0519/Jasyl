package spi.java;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-14 下午8:12
 */
public class ImageHello implements HelloService {


    public void hello(String name) {

        System.out.println("image " + name);
    }
}
