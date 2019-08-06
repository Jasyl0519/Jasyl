package spi.dubbo;


import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-14 下午8:14
 */
public class DubboSpiMain {

    public static void main(String[] args) {

        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
        
    }
}
