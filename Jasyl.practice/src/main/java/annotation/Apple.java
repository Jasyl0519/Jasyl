package annotation;

/**
 * Created by jason on 16/6/6.
 */

public class Apple {

    private String name;


    public static void main(String[] args) {

        Apple apple = new Apple();

        System.out.println(apple.getName());
    }


    public String getName() {
        return name;
    }

    @FruitName(value = "apple")
    public void setName(String name) {
        this.name = name;
    }
}
