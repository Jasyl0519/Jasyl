package spi.dubbo;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-15 下午4:40
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}