package com.thread;

/**
 * Created by jason on 16/6/1.
 */
public class Test {


    public static void main(String[] args) {

        ThreadService service = new ThreadServiceImpl();

        for (int i = 0; i < 5; i++) {

            service.execute(new ThreadTest());
        }




    }
}
