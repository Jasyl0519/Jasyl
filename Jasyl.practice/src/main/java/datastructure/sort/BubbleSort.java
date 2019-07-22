package datastructure.sort;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-19 23:25
 */
public class BubbleSort {
    
    public static void sort(int[] a, int n) {

        for (int i = 0; i < n; i++) {

            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;

            }
            
        }
        
    }

    public static void main(String[] args) {

        int[] a = new int[]{1,3,9,6,5,2,4,7,8};
        bubbleSort(a, a.length);

        for (int i = 0; i < a.length; i++) {

            System.out.println(a[i]);
        }

    }



    public static void bubbleSort(int a[], int n) {

        for (int i = 0; i < n; i++) {
            boolean flag = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;

            }
        }

    }
}
