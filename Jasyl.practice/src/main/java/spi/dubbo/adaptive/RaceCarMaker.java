package spi.dubbo.adaptive;

import org.apache.dubbo.common.URL;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-15 下午5:39
 */
public class RaceCarMaker implements CarMaker {

    WheelMaker wheelMaker;

    // 通过 setter 注入 AdaptiveWheelMaker
    public void setWheelMaker(WheelMaker wheelMaker) {
        this.wheelMaker = wheelMaker;
    }
    
    @Override
    public Car makeCar(URL url) {
        Wheel wheel = wheelMaker.makeWheel(url);
        return new RaceCar(wheel, ...);
    }
}
