package designMode.templateMethod;

/**
 * Created by jason on 16/5/20.
 */
public abstract class AbstractSort {

    /**
     *  需要子类去拓展的方法
     */
    public abstract void sort(int[] array);

    /**
     * 模板方法 final 不能修改
     */
    public final void printArray(int[] array) {
        sort(array);

        for (Integer i : array) {

            System.out.println(i);
        }
    }
}
