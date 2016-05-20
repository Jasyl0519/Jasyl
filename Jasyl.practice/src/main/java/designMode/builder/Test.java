package designMode.builder;

/**
 * Created by jason on 16/5/20.
 */
public class Test {

    public static void main(String[] args) {

        /*Builder builder = new Builder911();
        builder.buildCar();
        Director director = new Director(builder);
        director.build();*/

        Builder builder1 = new BuilderCayma();
        Director director1 = new Director(builder1);

        director1.build();

    }
}
