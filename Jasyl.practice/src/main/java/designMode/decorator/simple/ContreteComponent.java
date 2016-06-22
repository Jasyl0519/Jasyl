package designMode.decorator.simple;

/**
 * Created by jason on 16/6/22.
 */
public class ContreteComponent implements Component{

    @Override
    public void method() {
        System.out.println("原来的方法");
    }
}
