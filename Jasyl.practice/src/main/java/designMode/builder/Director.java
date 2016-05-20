package designMode.builder;

/**
 * Created by jason on 16/5/20.
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Car build() {

        builder.buildEngine();
        builder.buildFrame();
        builder.buildWheel();

        return builder.buildCar();
    }
}
