package designMode.adapter;

/**
 * Created by jason on 16/5/26.
 */
public class HDMIToVGI implements VGIPort {

    HDMIPort hdmiPort;

    public HDMIToVGI(HDMIPort hdmiPort){
        this.hdmiPort = hdmiPort;
    }

    public void workByVGI() {
        hdmiPort.workByHDMI();

    }


    public static void main(String[] args) {

        HDMIPort hdmiPort = new HDMIPort() {
            public void workByHDMI() {
                System.out.println("HDMI WORK");
            }
        };

        VGIPort vgiPort = new HDMIToVGI(hdmiPort);
        vgiPort.workByVGI();
    }
}
