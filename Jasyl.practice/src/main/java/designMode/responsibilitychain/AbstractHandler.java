package designMode.responsibilitychain;

/**
 * Description:
 * Author: lingyou
 * date: 2019-07-04 22:14
 */
public abstract class AbstractHandler implements Handler {

    private Handler nextHandler = null;


    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }


    public Handler getNextHandler() {
        return nextHandler;
    }


}
