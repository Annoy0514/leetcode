package leetcode.Array;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test6_MaxProduct {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
//        int[] nums = {0};
        System.out.println(maxProduct(nums));
    }

    /**
     * 动态规划的方法。
     *  维护一个数组：dpMax
     *  dpMax[i]表示以第i个元素结尾的子数组，乘积最大的值(这个数组必须包括第i个值)
     *      (1) nums[i]>=0 && dpMax[i-1]>0: dpMax[i] = dpMax[i-1] * nums[i];
     *      (2) nums[i]>=0 && dpMax[i-1]<0: 此时如果和前面累积的话就会变成负数,故 dpMax[i] = nums[i];
     *      (3) nums[i]<0: 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值dpMin[i]。
     *          (3).1 dpMin[i-1]<0: dpMax[i] = dpMin[i-1] * nums[i];
     *          (3).2 dpMin[i-1]>=0: 此时如果和前面累积的话就会变成更大的负数(最大值(正数) * nums[i](负数) < num[i](负数) ),故 dpMax[i] = nums[i];
     *
     *      总结：
     *          dpMax[i]的结果为 dpMax[i-1] * nums[i], nums[i], dpMin[i-1] * nums[i]中的最大值;
     *          同理，dpMin[i]的结果为dpMax[i-1] * nums[i], nums[i], dpMin[i-1] * nums[i]中的最小值;
     *          用一个变量max存储当前得到的最大值。
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==0) {
            return 0;
        }
        int max = nums[0];

        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMin[i-1] * nums[i], Math.max(dpMax[i-1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i-1] * nums[i], Math.min(dpMax[i-1] * nums[i], nums[i]));
            max = Math.max(max,dpMax[i]);
        }
        return max;
    }
}
