package designMode.singleton.hunger;

/**
 * Created by jason on 16/5/17.
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {

    }
    public static Singleton getSingleton() {
        return instance;
    }
}
