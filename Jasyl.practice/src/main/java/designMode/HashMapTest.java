package designMode;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * Author: lingyou
 * date: 2019-05-06 22:44
 */
public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                            map.get("1");
                            //System.out.println("1");
                        }
                    }, "ftf" + i).start();

                }
            }
        }, "ftf");
        t.start();
        t.join();
        System.out.println("1111");

        ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap();
        map1.put("111", "111");
        map1.get("111");
        map1.size();


    }
}
