package design_mode.dynamic_proxy;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyGeneratorUtils {
    /**
     * 把代理类的字节码写到硬盘上
     */
    public static void writeProxyClassToHardDisk(String path) {


        // 获取代理类的字节码  方法的第二个参数为被代理类所实现的全部接口
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", RealGoal.class.getInterfaces());

        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        writeProxyClassToHardDisk("/Users/jason/proxy.class");

    }
}
