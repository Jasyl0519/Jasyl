package spi.dubbo.adaptive;

import org.apache.dubbo.common.URL;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-15 下午5:38
 */
public interface CarMaker {

    Car makeCar(URL url);

}
