package designMode.responsibilitychain;

/**
 * Description:
 * Author: lingyou
 * date: 2019-07-04 22:16
 */
public class HandlerThree extends AbstractHandler {

    @Override
    public boolean isOk(String condition) {
        if ("ok".equals(condition)) {

            if (getNextHandler() != null) {
                return getNextHandler().isOk(condition);
            } else {

                System.out.println("HandlerThree has no next handler");
                return false;
            }
        }
        System.out.println("HandlerThree is not ok");
        return true;
    }
}
