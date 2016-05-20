package designMode.builder;

/**
 * Created by jason on 16/5/20.
 */
public class BuilderCayma implements Builder{
    public void buildFrame() {
        System.out.println("制造Cayma骨架");

    }

    public void buildEngine() {
        System.out.println("制造Cayma发动机");

    }

    public void buildWheel() {
        System.out.println("制造Cayma车轮");

    }

    public Car buildCar() {
        System.out.println("Cayma汽车各部组装完毕");

        return new Car();
    }
}
