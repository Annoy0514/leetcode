package leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个数组 prices ，它的第i个元素prices[i]表示一支给定股票第 i 天的价格。
 *
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test2_MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{7,6,5,4,3,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min_prices = prices[0];
        // 遍历股票的值
        for (int i = 1; i < prices.length; i++) {
            // 双层循环时间复杂度过高
//            for (int j = i+1; j < prices.length; j++) {
//                if(prices[j] >= prices[i]){
//                    if(profit <= prices[j]-prices[i]) {
//                        profit = prices[j]-prices[i];
//                    }
//                }
//            }
            // 找出最小值，与后面比这个最小值大的值求差(得到收益profit)
            if(min_prices > prices[i]) {
                min_prices=prices[i];
            }
            // 找出这些差值中最大的作为收益(max_profit)
            if(profit <= (prices[i]-min_prices)) {
                profit = prices[i]-min_prices;
            }
        }
        // 重复上述过程就是一个求最大差(最大收益)的过程
        // 每次循环都是得到：该时刻购入股票所能得到的最大收益
        return profit;
    }
}
