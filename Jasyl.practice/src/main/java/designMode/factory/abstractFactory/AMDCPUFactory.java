package designMode.factory.abstractFactory;

/**
 * Created by jason on 16/5/18.
 */
public class AMDCPUFactory implements Provider{

    public CPUFactory createCPUFactory() {
        return new AMDCPU();
    }
}
