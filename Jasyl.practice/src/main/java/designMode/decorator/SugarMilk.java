package designMode.decorator;

/**
 * Created by jason on 16/5/30.
 */
public class SugarMilk extends Decorator {

    @Override
    public void showCoffee() {
        System.out.println("加糖+加牛奶");
        super.showCoffee();
    }

    @Override
    public float showPrice() {

        return super.showPrice() + 10;
    }


    public static void main(String[] args) {
        Coffee coffee = new Coffee("拿铁", 20);

        //加糖
        Decorator sugar = new Sugar();
        sugar.setCoffee(coffee);
        sugar.showCoffee();

        System.out.println(sugar.showPrice());

        //加牛奶
        Decorator sugarMilk = new SugarMilk();
        sugarMilk.setCoffee(coffee);
        sugarMilk.showCoffee();
        System.out.println(sugarMilk.showPrice());

    }

}
