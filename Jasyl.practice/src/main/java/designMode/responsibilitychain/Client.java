package designMode.responsibilitychain;

/**
 * Description:
 * Author: lingyou
 * date: 2019-07-04 22:26
 */
public class Client {

    public static void main(String[] args) {
        AbstractHandler handlerOne = new HandlerOne();
        AbstractHandler handlerTwo = new HandlerTwo();
        AbstractHandler handlerThree = new HandlerThree();

        handlerOne.setNextHandler(handlerTwo);
        handlerTwo.setNextHandler(handlerThree);

        handlerOne.isOk("ok");
    }
}
