package designMode.decorator.simple;

/**
 * Created by jason on 16/6/22.
 */
public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    public void method(){
        component.method();
    }
}
