package 高频题;

import java.util.Random;

/**
 *  https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */

public class Test4_数组中的第K个最大元素 {
    // 引入随机数，防止性能退到O(N^2)
    private final static Random random = new Random(System.currentTimeMillis());

    /**
     * 快排，分而治之的思想
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 第k大的数，实际位置就是在 len - k[递增排序]
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len-1;

        while (true) {
            int pivotIndex = partition(nums, left, right);
            if(pivotIndex == target) {
                return nums[pivotIndex];
            } else if(pivotIndex < target) {
                // 结果在右半部分
                left = pivotIndex + 1;
            } else {
                // 结果在左半部分
                right = pivotIndex - 1;
            }
        }
    }

    /**
     * 双路快排
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int pivot = nums[left];
        // le:less equals,即nums[left+1,le) <= pivot
        int le = left + 1;
        // ge:greater equals, 即nums(ge,right] >= pivot
        int ge = right;

        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }

            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            // le移动到第一个大于等于 pivot 的位置
            // ge移动到第一个小于等于 pivot 的位置
            if(le >= ge) {
                break;
            }
            // 在左区间和右区间都找到了属于对方区间的元素时，需要进行交换
            swap(nums, le, ge);
            le++;
            ge--;
        }
        /**
         * 退出循环时，有两种情况：
         *  1.le和ge重合，此时left交换ge和le都可以。
         *  2.le和ge不重合，不重合的情况下一定是ge在左边，le在右边。此时交换left和ge才可以保证left在正确的位置，否则左边会是一个很大的数。
         */
        swap(nums, left, ge);
        return ge;
    }

    private void swap(int[] nums, int index_1, int index_2) {
        int temp = nums[index_1];
        nums[index_1] = nums[index_2];
        nums[index_2] = temp;
    }
}
