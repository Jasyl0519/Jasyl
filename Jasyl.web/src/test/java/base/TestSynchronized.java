package base;


public class TestSynchronized {


    private int i = 0;

    public synchronized int add(long loop) {
        for (int j = 0; j < loop; j++) {
            i++;
        }
        return i;
    }
}
