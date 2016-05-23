package designMode.templateMethod;

/**
 * Created by jason on 16/5/20.
 */
public class test {

    public static void main(String[] args) {

        int[] array = {10,2,6,8,11,44,33,9};
        /*AbstractSort bs = new BubbleSort();
        bs.printArray(array);*/

        AbstractSort abstractSort = new QuickSort();
        abstractSort.printArray(array);

    }

}
