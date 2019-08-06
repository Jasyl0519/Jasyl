package designMode.responsibilitychain;

/**
 * Description:
 * Author: lingyou
 * date: 2019-07-04 22:16
 */
public class HandlerOne extends AbstractHandler {

    @Override
    public boolean isOk(String condition) {
        if ("ok".equals(condition)) {
            if (getNextHandler() != null) {
                return getNextHandler().isOk(condition);
            } else {

                System.out.println("HandlerOne has no next handler");
                return false;
            }
        }
        System.out.println("HandlerOne is not ok");
        return false;
    }
}
