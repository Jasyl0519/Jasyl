package spi.dubbo.adaptive;

import org.apache.dubbo.common.URL;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-15 下午5:34
 */
public interface WheelMaker {

    Wheel makeWheel(URL url);

}
