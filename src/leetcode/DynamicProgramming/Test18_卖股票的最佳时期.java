package leetcode.DynamicProgramming;

/**
 * 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
 * 2.如果不能获取到任何利润，请返回0
 * 3.假设买入卖出均无手续费
 */


public class Test18_卖股票的最佳时期 {
    public int maxProfit (int[] prices) {
        // 记录数组中的最小值
        int minPrice = Integer.MAX_VALUE;
        // 返回结果(利润)
        int res = 0;
        // 遍历数组，找到其中的最小值(最小值往后的数组中才存在获得最大利润的点)
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if(prices[i] - minPrice > res) {
                res = prices[i] - minPrice;
            }
        }
        return res;
    }
}
