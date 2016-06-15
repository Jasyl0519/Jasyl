package jvm.classloading;

/**
 * Created by jason on 16/6/13.
 */
public class SuperClass {
    public static int A = 1;


    static {
        System.out.println("super class init...");
        A = 2;
    }

    public static int value = 123;

    public static final String helloworld = " hello world...";
}



