package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test3_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {20,8,8,9,6,25,17,19};
        System.out.println(lengthOfLIS(nums));
//        System.out.println(lengthOfLIS(nums)*100);
    }

    public static int lengthOfLIS(int[] nums) {
        // 先排除特例长度为0
        if(nums.length==0) return 0;
        /**
         *  动态规划：
         *      dp[i]代表以nums[i]结尾的最长递增子序列长度。
         *      此时，nums[i]一定要在子序列中，必须是子序列的最后一个元素。
         *  状态转移方程：
         *      nums[i]需要严格大于它前面的某个数，才可以形成一个以nums[i]结尾的更长的子序列。
         */
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 规定严格递增子序列
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            // dp中最大的数代表最大递增子序列的长度
            temp = Math.max(temp,dp[i]);
        }
        return temp;
    }

    private static int lengthOfLIS_2(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            // temp保存dp中最大的值，就代表最长递增子序列长度
            temp = Math.max(temp,dp[i]);
        }
        return temp;
    }
}
