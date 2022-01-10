package base;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCas {


    private AtomicInteger i = new AtomicInteger(0);

    public int add(long loop) {
        for (int j = 0; j < loop; j++) {
            i.addAndGet(1);
        }
        return i.get();
    }
}
