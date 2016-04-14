import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by jason on 16/4/14.
 */
@Slf4j
public class TestJason {


    @Test
    public void test(){

        log.info("abc");

        int i=0,j=0;

        for (i = 0; i < 10; j++) {
            System.out.print(i);
            System.out.println(j);
            i ++;
        }

    }

}
