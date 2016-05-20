package designMode.factory.abstractFactory;

/**
 * Created by jason on 16/5/18.
 */
public class InterCPU implements CPUFactory{
    public void createCPU() {
        System.out.println("INTER CPU");
    }
}
