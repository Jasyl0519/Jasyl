package designMode.factory.abstractFactory;

/**
 * Created by jason on 16/5/20.
 */
public class Test {


    public static void main(String[] args) {



        /*CPUFactory cpuFactory = new AMDCPU();
        cpuFactory.createCPU();*/

        Provider provider = new AMDCPUFactory();

        provider.createCPUFactory().createCPU();

    }
}
