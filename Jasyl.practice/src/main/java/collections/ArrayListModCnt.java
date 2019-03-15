package collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2019-02-26 下午5:13
 */
public class ArrayListModCnt {

    private static ArrayList<String> list = new ArrayList();



    public static class ThreadOne implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        public void run() {
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()){
                String i = iterator.next();
                System.out.println("ThreadOne 遍历:" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        }
    }

    public static class ThreadSecond implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        public void run() {

           int i = 0;
           while (i < 6) {

               if(i == 3){
                   list.remove(i);
                   System.out.println("删除" + i);
               }
               i++;
           }

        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            list.add("" + i);

        }

        new Thread(new ThreadOne()).start();
        new Thread(new ThreadSecond()).start();


    }
}
