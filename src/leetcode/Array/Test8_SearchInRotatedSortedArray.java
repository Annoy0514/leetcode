package leetcode.Array;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 *
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Test8_SearchInRotatedSortedArray {
    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,8,1,2,3};
//        int[] nums = {0,1,2,4,5,6,7};
        int[] nums = {1,3};
        System.out.println(search(nums,3));
    }

    public static int search(int[] nums, int target) {
        // 1.长度为0时
        if(nums.length == 0) {
            return -1;
        }

        // 2.长度为1时
        if(nums.length == 1){
            if(target!=nums[0]){
                return -1;
            } else {
                return 0;
            }
        }

        // 3.长度为n时，进行二分法查询
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            /**
             * 中间值等于目标时，返回中间值索引。
             */
            if(nums[mid] == target){
                return mid;
            }

            /**
             * 二分法
             *      (1)如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [nums[l],nums[mid]]，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
             *      (2)如果 [mid, r] 是有序数组，且 target 的大小满足 [nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。
             */
            // 左有序
            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 右有序
                if(nums[mid] < target && target <= nums[nums.length-1]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
