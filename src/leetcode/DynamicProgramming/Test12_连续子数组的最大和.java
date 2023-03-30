package leetcode.DynamicProgramming;

/**
 * 输入一个长度为n的整型数组array，
 * 数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。
 * 求所有子数组的和的最大值。
 */

public class Test12_连续子数组的最大和 {

    /**
     * 动态规划法：
     *  设动态规划表dp，dp[i]表示以元素array[i]为结尾的连续子数组最大和。
     * 转移方程：
     *  dp[i] = Math.max(dp[i-1]+array[i],array[i])
     * 具体思路：
     *  1.遍历数组，比较 dp[i-1]+array[i] 和 array[i] 的大小。
     *  2.保证子数组的最大值，每次比较 sum ,取两者的最大值。
     *  3.用 max 记录计算过程中产生的最大连续子数组的和。
     *
     * @param array
     * @return
     */

    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            // 状态转移方程，确定dp[i]的最大值
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            // 每次比较，保存出现的最大值
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
