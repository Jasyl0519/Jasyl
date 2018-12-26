package instrument;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-09-06 下午3:46
 */
public class PeopleClassFileTransformer implements ClassFileTransformer {

    /**
     * 通过javassist修改字节码
     *
     * @return
     * @throws IllegalClassFormatException
     * @paramloader
     * @paramclassName
     * @paramclassBeingRedefined
     * @paramprotectionDomain
     * @paramclassfileBuffer
     */

    public byte[] transform(ClassLoader loader, String className, Class classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        System.out.println("load class:" + className);

        if ("com/yao/intrumentation/People".equals(className)) {

            try {

                //通过javassist修改sayHello方法字节码

                CtClass ctClass = ClassPool.getDefault().get(className.replace('/', '.'));

                CtMethod sayHelloMethod = ctClass.getDeclaredMethod("sayHello");

                sayHelloMethod.insertBefore("System.out.println(\"before sayHello----\");");

                sayHelloMethod.insertAfter("System.out.println(\"after sayHello----\");");

                return ctClass.toBytecode();

            } catch (NotFoundException e) {

                e.printStackTrace();

            } catch (CannotCompileException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        return classfileBuffer;

    }

}