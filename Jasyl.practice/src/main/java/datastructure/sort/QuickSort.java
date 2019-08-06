package datastructure.sort;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-20 21:39
 */

public class QuickSort {

    public static void sort(int[] array, int start, int end) {
        if(start > end){
            //如果只有一个元素，就不用再排下去了
            return;
        }

        int partition = partition(array, start, end);
        sort(array, start, partition-1);
        sort(array, partition+1, end);

    }

    public static int partition(int[] array, int start, int end) {
        //最后一个数作为基准值
        int pivot = array[end];

        while (start < end) {
            //从左开始找比pivot大的值，找到了跳出while循环
            while(start < end && array[start] <= pivot) {
                start++;
            }

            if (start < end) {
                //比pivot大的值和pivot交换
                swap(array, start, end);
                //交换成功之后，end--，往前前进一步
                end--;

            }

            //从右开始找比pivot小的值，找到了跳出while循环
            while(start < end && array[end] >= pivot) {
                end--;
            }


            if (start < end) {
                //比pivot小的值和pivot交换
                swap(array, start, end);
                //交换成功之后，end--，往前前进一步
                start++;

            }
        }
        return end;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {


        int[] a = new int[]{1,3,9,6,5,2,4,7,8};
        sort(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {

            System.out.println(a[i]);
        }
    }
}
