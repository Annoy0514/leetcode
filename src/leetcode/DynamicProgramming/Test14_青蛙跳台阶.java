package leetcode.DynamicProgramming;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

public class Test14_青蛙跳台阶 {
    /**
     * 动态规划法：
     *  1.处理思路：如果从第n阶台阶往下走，则有两种方案：①走到n-1阶台阶 ②走到n-2阶台阶，假设f[i]表示第i个台阶上可能的方法数。
     *  2.动态规划方程：f[n] = f[n-1] + f[n-2]
     *  3.初始条件：f[0] = 1, f[1] = 1
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
