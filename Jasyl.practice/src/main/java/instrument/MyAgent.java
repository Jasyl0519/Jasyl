package instrument;

import java.lang.instrument.Instrumentation;

/**
 * Description:
 *
 * @author: lingyou
 * date: 2018-09-06 下午3:46
 */
public class MyAgent {

    /**
     * 该方法是一个类作为agent类必备的
     *
     * @paramagentArgs
     * @paraminst
     */

    public static void premain(String agentArgs, Instrumentation inst) {

        //加入ClassFileTransfomer

        inst.addTransformer(new PeopleClassFileTransformer());

    }

}