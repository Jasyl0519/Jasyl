package designMode.proxy.dynamicProxy.example;

/**
 * Created by jason on 16/6/3.
 */
public class UserServiceImpl implements UserService{

    @Override
    public void add(String username) {
        System.out.println("add user: " + username);
    }
}
