import java.util.Date;

/**
 * Created by jason on 16/4/10.
 */
public final class Sub{
    private final Date date;

    Sub(){
        date = new Date();
    }

    public void overrideMe(){
        System.out.println(date);
    }


    public static void main (String args[]){

        /*Super s = new Super();
        s.overrideMe();*/

        /*Super s = new Sub();

        s.overrideMe();*/
        Sub sub = new Sub();

        sub.overrideMe();
    }
}
