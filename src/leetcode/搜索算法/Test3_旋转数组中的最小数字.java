package leetcode.搜索算法;

/**
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，
 * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 请问，给定这样一个旋转数组，求数组中的最小值。
 */

public class Test3_旋转数组中的最小数字 {
    /**
     * 使用二分法解决该问题
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (left < right) {
            // 当右边界-左边界==1时，说明此时数组中就剩下两个元素，最小值就是两个元素中的其中一个
            if(right - left == 1) {
                break;
            }
            // 计算中间元素的位置
            mid = left + (right - left)/2;
            // 1.此时，最小值应该在 【左边的数组】 中。
            if(array[mid] < array[right]) {
                right = mid;
            }
            // 2.此时，中间位置分割开的两侧都是非降序数组，而中间位置的元素的值大于右侧，则最小值应当在 【右边的数组】 中。
            else if(array[mid] > array[right]) {
                left = mid;
            }
            // 3.此时，无法判断，则从右边界往前，逐个判断
            // 若是区间中点值等于区间右界值，则是不容易分辨最小数字在哪半个区间，比如[1,1,1,0,1]，应该逐个缩减右界。
            else if(array[mid] == array[right]) {
                right--;
            }
        }
        return Math.min(array[left],array[right]);
    }
}
