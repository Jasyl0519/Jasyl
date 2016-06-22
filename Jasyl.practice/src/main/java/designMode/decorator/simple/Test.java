package designMode.decorator.simple;

/**
 * Created by jason on 16/6/22.
 */
public class Test {

    public static void main(String[] args) {

        Component component = new ContreteComponent();
        System.out.println("------------------------------");
        component.method();

        ContreteDecoratorA contreteDecoratorA = new ContreteDecoratorA(component);
        System.out.println("------------------------------");
        contreteDecoratorA.method();
        contreteDecoratorA.methodA();

        ContreteDecoratorB contreteDecoratorB = new ContreteDecoratorB(component);
        System.out.println("------------------------------");
        contreteDecoratorB.method();
        contreteDecoratorB.methodB();

        ContreteDecoratorB contreteDecorator = new ContreteDecoratorB(contreteDecoratorA);
        System.out.println("------------------------------");
        contreteDecorator.method();
        contreteDecorator.methodB();


}
}
