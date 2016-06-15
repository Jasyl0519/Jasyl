package jvm.classloading;

/**
 * Created by jason on 16/6/13.
 */
public class SubClass extends SuperClass{

    static {
        System.out.println("sub class init...");
    }

    public static int B = A;


}
