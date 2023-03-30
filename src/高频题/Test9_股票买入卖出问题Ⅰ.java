package 高频题;

import java.util.Arrays;
import java.util.Scanner;

public class Test9_股票买入卖出问题Ⅰ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] nums = s.split(",");
        int[] prices = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prices[i] = Integer.valueOf(nums[i]);
        }
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        if(prices.length == 0 ||prices == null) {
            return 0;
        }
        int res = 0;
        int len = prices.length;

        /**
         * 1.dp[i][0]:持有股票
         * 2.dp[i][1]:不持有股票，本日卖出，下一天为冷冻期。
         * 3.dp[i][2]:不持有股票，本日不卖出，下一天非冷冻期
         */
        int[][] dp = new int[len][3];

        /**
         * 初始状态
         */
        // 1.第一天持有，只可能是买入
        dp[0][0] = -prices[0];

        // 2.第一天不持有：当天买入卖出，导致第二天冷冻期，并且没有收益
        dp[0][1] = Integer.MIN_VALUE;

        // 3.第一天不持有：相当于没有买入，收益为0
        dp[0][2] = 0;

        for (int i = 1; i < len; i++) {
            // 1.持有股票：1.昨天持有；2.今天买入(昨天不持有，并且不是卖出)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - prices[i]);

            // 2.不持有，今天卖出：(昨天持有)
            dp[i][1] = dp[i-1][0] + prices[i];

            // 3.不持有，也不卖出：1.昨天卖出，不持有；2.昨天没卖，不持有.
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);

        }
        // 最后一天持有股票没有意义，所以不用比较dp[len-1][0]
        return Math.max(dp[len-1][1],dp[len-1][2]);
    }
}
