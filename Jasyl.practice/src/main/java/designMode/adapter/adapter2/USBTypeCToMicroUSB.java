package designMode.adapter.adapter2;

/**
 * Created by jason on 16/5/26.
 */
public class USBTypeCToMicroUSB implements MicroUSB{

    MicroUSB microUSB;


    public USBTypeCToMicroUSB(MicroUSB microUSB) {

        this.microUSB = microUSB;
    }


    public void process() {
        System.out.println("USBTypeC to MicroUSB");

        microUSB.process();
    }
}
