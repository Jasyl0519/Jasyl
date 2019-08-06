package datastructure.sort;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-20 20:57
 */
public class ShellSort {
    
    public static void sort(int[] a) {

        int len = a.length;
        int gap = len / 2;

        while (gap > 0) {

            for (int i = gap; i < len; i++) {
                int temp = a[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && a[preIndex] > temp) {
                    a[preIndex+gap] = a[preIndex];
                    preIndex -= gap;

                }
                a[preIndex+gap]=temp;
                

            }
            gap /= 2;

        }

    }

    public static void main(String[] args) {


        int[] a = new int[]{1,3,9,6,5,2,4,7,8};
        sort(a);

        for (int i = 0; i < a.length; i++) {

            System.out.println(a[i]);
        }
    }

}
