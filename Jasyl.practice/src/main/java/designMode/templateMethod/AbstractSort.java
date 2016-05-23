package designMode.templateMethod;

/**
 * Created by jason on 16/5/20.
 */
public abstract class AbstractSort {

    public abstract void sort(int[] array);

    public final void printArray(int[] array) {
        sort(array);

        for (Integer i : array) {

            System.out.println(i);
        }
    }
}
