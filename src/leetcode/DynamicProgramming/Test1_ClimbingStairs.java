package leetcode.DynamicProgramming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class Test1_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }

    /**
     * 动态规划:
     *  考虑到最后一步，有可能走一个台阶也可能走两个台阶。
     *  意味着，在i台阶的方案数是爬到i-1台阶的方案数和爬到i-2台阶的方案数的和。
     *  递推出当 i>2时, dp[i] = dp[i-1] + dp[i-2]
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1, b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
