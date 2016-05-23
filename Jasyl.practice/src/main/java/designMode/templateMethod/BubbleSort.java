package designMode.templateMethod;

/**
 * Created by jason on 16/5/20.
 */
public class BubbleSort extends AbstractSort{
    @Override
    public void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                //从小到大排列
                if (array[i] > array[j]) {

                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


}
