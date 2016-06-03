package designMode.proxy.dynamicProxy.example;

/**
 * Created by jason on 16/6/3.
 */
public class TestClient {

    public static void main(String[] args) {

        LogHandler logHandler = new LogHandler();
        UserService userService = (UserService) logHandler.newProxyInstance(new UserServiceImpl());

        userService.add("jason");
    }
}
