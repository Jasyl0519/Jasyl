package designMode.adapter.adapter2;

/**
 * Created by jason on 16/5/26.
 */
public class Main {

    public static void main(String[] args) {

        MicroUSB microUSB = new Iphone();

        USBTypeCToMicroUSB usbTypeCToMicroUSB = new USBTypeCToMicroUSB(microUSB);

        usbTypeCToMicroUSB.process();


    }
}
