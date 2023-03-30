package leetcode.Array;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为O(log n) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test7_FindMin {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {11,13,15,17};
        int[] nums = {3,4,5,1,2};

        System.out.println(findMin(nums));
    }

    /**
     * 分析：
     *      由于时间复杂度规定为 O(log n) ，考虑使用二分法。
     *      最小值的位置只有三种情况：
     *          (1) 当中间值大于左右两端值，说明最小值在右侧。如[3,4,5,6,1,2]
     *          (2) 当中间值小于左右两端值，说明最小值在左侧。如[7,1,2,3,4,5,6]
     *          (3) 当中间值介于左右两端值之间，说明最小值就在左端。如[1,2,3,4,5,6]
     *      左右端位置相差为1时，此时左右端其中一个必定是最小值。
     *      (二分法，不停将mid位置的值赋给左右端其中一个值，此时mid就作为新的端值，再二分...)
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            if(right - left == 1) {
                break;
            }
            mid = left + (right - left)/2;
            if(nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
            }
            else if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid;
            }
            else if (nums[mid] > nums[left] && nums[mid] < nums[right]) {
                break;
            }
        }
        return Math.min(nums[left],nums[right]);
    }

}
