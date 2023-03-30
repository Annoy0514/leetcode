package leetcode.Array;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class Test5_MaxSubArray {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        /**
         * 动态规划算法
         * 定位到i的位置的数据，i-1大于0，则将i加到当前保存的最大值上。
         * 比较加上i后的最大值与没有加i的最大值，如果加上i后的值大，则将该值替换最大值。
         * 依次继续往后遍历。
         * 最终结果就是最大的子序列和。
         */
        int pre = 0;
        int maxSub = nums[0];
        for (int x : nums) {
            // 可以只用一个变量 pre 来维护对于当前 f(i) 的 f(i−1) 的值是多少
            pre = Math.max(pre+x,x);
            maxSub = Math.max(maxSub,pre);
        }
        return maxSub;
    }
}
