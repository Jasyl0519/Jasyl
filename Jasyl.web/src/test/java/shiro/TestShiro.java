package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jason on 16/6/20.
 */
public class TestShiro {


    @Test
    public void testHelloWorld(){

        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1234");


        try {
            subject.login(token);

            System.out.println("login success");

        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("login failure");
        }


        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        subject.logout();

    }


    @Test
    public void testCustomRealm(){
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm" +
                ".ini");

        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123");

        subject.login(usernamePasswordToken);

        Assert.assertEquals(true, subject.isAuthenticated());

        subject.logout();

    }

    @Test
    public void testJDBCRealm(){
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory
                ("classpath:shiro-jdbc-realm.ini");

        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123");

        subject.login(usernamePasswordToken);

        Assert.assertEquals(true, subject.isAuthenticated());

        subject.logout();

    }


    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }


}
