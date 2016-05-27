package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by jason on 16/5/23.
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* spring.aop.*.*(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest(){
        System.out.println("before test");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("after test");

    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {
        System.out.println("around start");

        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around end");

        return o;
    }
}
