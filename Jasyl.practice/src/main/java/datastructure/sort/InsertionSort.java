package datastructure.sort;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-19 23:39
 */
public class InsertionSort {

    private static class SingletonClass {
        private static final InsertionSort singleton = new InsertionSort();
    }

    private InsertionSort() {

    }

    public static InsertionSort getSinleton() {
        return SingletonClass.singleton;

    }


    //
    //}
    //
    //public volatile static InsertionSort singleton;
    //
    //public static InsertionSort getSinleton() {
    //
    //    if (singleton == null) {
    //        synchronized (InsertionSort.class) {
    //            if (singleton == null) {
    //                singleton = new InsertionSort();
    //            }
    //
    //        }
    //    }
    //    return singleton;
    //}





    public static void sort(int a[], int n) {

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;

            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];

                } else {
                    break;
                }

            }
            a[j+1] = value;

        }

    }

    public static void main(String[] args) {


        int[] a = new int[]{1,3,9,6,5,2,4,7,8};
        sort(a, a.length);

        for (int i = 0; i < a.length; i++) {

            System.out.println(a[i]);
        }
    }


    public static void insertionSort(int[] a, int n){
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;

            for (; j >= 0 ; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }

            a[j+1] = value;
        }

    }
}
