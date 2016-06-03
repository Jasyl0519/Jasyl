package designMode.proxy.simpleProxy;

/**
 * Created by jason on 16/6/3.
 *
 * 真实的对象
 */
public class Pursuit implements GiveGift {

    private SchoolGirl mm;

    Pursuit(SchoolGirl mm){

        this.mm = mm;

    }

    @Override
    public void giveDolls() {

        System.out.println(mm.getName() + "送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(mm.getName() + "送你花");

    }

    @Override
    public void giveChocolate() {
        System.out.println(mm.getName() + "送你巧克力");

    }
}
