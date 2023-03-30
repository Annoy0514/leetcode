package 高频题;

import java.util.Scanner;

public class Test10_股票买入卖出问题Ⅱ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int[] prices = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            prices[i] = Integer.valueOf(split[i]);
        }
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        // 初始化
        // 1.第一天未持有
        dp[0][0] = 0;

        // 2.第一天持有
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 1.不持有股票
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);

            // 2.持有股票
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        // 最终返回结果，未持有股票一定比持有股票利润高(只需要dp[][0])
        return dp[len-1][0];
    }
}
