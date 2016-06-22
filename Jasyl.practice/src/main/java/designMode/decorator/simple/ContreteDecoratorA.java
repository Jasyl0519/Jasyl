package designMode.decorator.simple;

/**
 * Created by jason on 16/6/22.
 */
public class ContreteDecoratorA extends Decorator{

    public ContreteDecoratorA(Component component) {
        super(component);
    }

    public void methodA(){
        System.out.println("被装饰器A扩展的功能");

    }

    public void method(){
        System.out.println("针对该方法加一层A包装");
        super.method();
        System.out.println("A包装结束");
    }
}
