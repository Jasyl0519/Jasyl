package spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-15 下午4:39
 */
@SPI
public interface Robot {

    void sayHello();
}
