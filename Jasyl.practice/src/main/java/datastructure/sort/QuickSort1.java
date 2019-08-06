package datastructure.sort;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-20 21:39
 */
public class QuickSort1 {

    public static void sort(int[] array, int left, int right) {
        if (array == null || left >= right || array.length <= 1)
            return;
        int mid = partition(array, left, right);
        sort(array, left, mid);
        sort(array, mid + 1, right);


    }

    public static int partition(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (temp < array[right] && left < right) {
                --right;
            }

            if (left < right) {
                array[left] = array[right];
                ++left;
            }

            while (temp >= array[left] && left < right) {
                ++left;
            }

            if (left < right) {
                array[right] = array[left];
                --right;
            }
        }
        array[left] = temp;
        return left;

    }


    public static void main(String[] args) {


        int[] a = new int[]{ 1, 3, 9, 6, 5, 2, 4, 7, 8 };
        sort(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {

            System.out.println(a[i]);
        }
    }
}
