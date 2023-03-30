package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test2_CoinChange {
    public static void main(String[] args) {
        int[] coins = {3,4};
        int amount = 5;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount==0) {return 0;}
        int max = amount + 1;
        // dp[i]存储通过取出钱袋中的硬币，使得硬币价值达到 i 的方案个数。
        int[] dp = new int[amount + 1];
        // 初始化数组
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 一层循环遍历目标金额
        for (int i = 1; i <= amount; i++) {
            // 二层循环遍历钱包
            for (int j = 0; j < coins.length; j++) {
                // 当钱包里面的钱coins[j]小于amount，表示可以塞进去
                if (coins[j] <= i) {
                    // 此时需要从amount-coins[j]的状态转移，并且使用该硬币(+1)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        /**
         *  返回值
         *      当 dp[amount] > amount 时，表示没有一种方案满足来达到目标值。
         *      当 dp[amount] <= amount 时，表示存在方案满足达到目标值。
         */
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
