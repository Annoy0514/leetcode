package leetcode.DynamicProgramming;

/**
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
 * 1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 2.如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
 * 3.该题定义的子数组的最小长度为1，不存在为空的子数组，即不存在[]是某个数组的子数组
 * 4.返回的数组不计入空间复杂度计算
 */

public class Test13_连续子数组的最大和_2 {
    /**
     * 动态规划法：
     *  1.创建动态规划数组，记录到下标i为止，连续子数组的最大和。
     *  2.准备左右双指针，记录每次连续子数组的首尾；再准备左右双指针，记录最大和并且区间最长的连续子数组的首尾。
     *  3.遍历数组，对于每个元素应用上面的状态转移公式记录其dp值，更新区间首尾。
     *  4.出现一个最大值，并且长度区间更长时，更新记录最长区间的双指针。
     *  5.根据记录的最长子数组的位置取数组。
     * @param array
     * @return
     */
    public int[] FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        // 滑动区间左右指针
        int left = 0, right = 0;
        // 结果集区间左右指针
        int res_left = 0, res_right = 0;
        for (int i = 1; i < array.length; i++) {
            right++;
            // 状态转移方程，计算连续子数组的最大和
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
            // 如果dp[i-1]+array[i] < array[i]，意味着最大值在后续的连续子数组中，则滑动窗口向后移动
            if(dp[i-1]+array[i] < array[i]) {
                left = right;
            }
            // 更新最大值
            if(dp[i] > max || dp[i] == max && (right - left + 1) > (res_right - res_left + 1)) {
                max = dp[i];
                res_left = left;
                res_right = right;
            }
        }
        // 结果集
        int[] res = new int[res_right - res_left + 1];
        for(int i = res_left; i <= res_right; i++) {
            res[i - res_left] = array[i];
        }
        return res;
    }
}
