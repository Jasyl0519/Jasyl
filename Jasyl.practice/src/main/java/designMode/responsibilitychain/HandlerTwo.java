package designMode.responsibilitychain;

/**
 * Description:
 * Author: lingyou
 * date: 2019-07-04 22:16
 */
public class HandlerTwo extends AbstractHandler {

    @Override
    public boolean isOk(String condition) {
        if ("ok".equals(condition)) {

            if (getNextHandler() != null) {
                return getNextHandler().isOk(condition);
            } else {

                System.out.println("HandlerTwo has no next handler");
                return false;
            }
        }
        System.out.println("HandlerTwo is ok");
        return true;
    }
}
