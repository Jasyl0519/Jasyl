package datastructure;

/**
 * Description:
 * Author: lingyou
 * date: 2019-06-21 11:30
 */

/**
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 *
 */
public class Leetcode33 {
    int [] nums;
    int target;

    public int findRotateIndex(int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int pivot = (left + right) / 2;

            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if (nums[pivot] < nums[left]) {
                    right = pivot - 1;

                } else {
                    left = pivot + 1;
                }
            }

        }
        return 0;

    }

    public int search(int left, int right) {
        while (left <= right) {

            int pivot = (left + right) / 2;
            
            if (nums[pivot] == target) {
                return pivot;
            } else {
                if (target < nums[pivot]) {
                    right = pivot - 1;

                } else {
                    left = pivot + 1;

                }
            }
        }
        return -1;

    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotateIndex = findRotateIndex(0, n - 1);
        if (nums[rotateIndex] == target) {
            return rotateIndex;
        }
        if (rotateIndex == 0) {
            return search(0, n - 1);
        }
        if (target < nums[0]) {
            return search(rotateIndex, n - 1);
        }
        return search(0, rotateIndex);

    }


    public static void main(String[] args) {

        int[] a = new int[]{ 90,91,92,100,101,5,6,7,8,9,9 };

        Leetcode33 leetcode33 = new Leetcode33();
        int index = leetcode33.search(a, 100);
        System.out.println(index);



        
    }
}
