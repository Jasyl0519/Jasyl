package designMode.decorator.simple;

/**
 * Created by jason on 16/6/22.
 */
public class ContreteDecoratorB extends Decorator {

    public ContreteDecoratorB(Component component) {
        super(component);
    }

    public void methodB(){
        System.out.println("被装饰器B扩展的功能");
    }

    public void method(){
        System.out.println("针对该方法加一层B包装");
        super.method();
        System.out.println("A包装结束");

    }
}
