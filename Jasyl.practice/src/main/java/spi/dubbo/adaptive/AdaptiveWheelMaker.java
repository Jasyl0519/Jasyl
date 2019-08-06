package spi.dubbo.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-03-15 下午5:36
 */
public class AdaptiveWheelMaker implements WheelMaker {
    @Override
    public Wheel makeWheel(URL url) {

        String wheelMakerName = url.getParameter("Wheel.maker");

        WheelMaker wheelMaker = ExtensionLoader.getExtensionLoader(WheelMaker.class).getExtension(wheelMakerName);


        return wheelMaker.makeWheel(url);
    }
}
