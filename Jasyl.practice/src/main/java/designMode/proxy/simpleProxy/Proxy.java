package designMode.proxy.simpleProxy;

/**
 * Created by jason on 16/6/3.
 *
 * 代理类
 */
public class Proxy implements GiveGift {

    //追求者
    private Pursuit pursuit;


    Proxy(SchoolGirl mm){

        this.pursuit = new Pursuit(mm);
    }

    @Override
    public void giveDolls() {

        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();

    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();

    }
}
