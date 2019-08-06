package designMode.singleton;

/**
 * Description:
 * Author: lingyou
 * date: 2019-08-05 08:44
 */
public class StaticSingleton {

    private StaticSingleton() {

    }

    private static class SingletonHolder {
        private static StaticSingleton staticSingleton = new StaticSingleton();
        
    }

    public static StaticSingleton getInance() {
        return SingletonHolder.staticSingleton;
    }
}
