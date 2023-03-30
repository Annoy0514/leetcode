package leetcode.DynamicProgramming;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test7_HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        // 1.nums是否为空的情况
        if(nums == null || nums.length ==0) return 0;
        // 2.nums只有一个值的情况
        if(nums.length == 1) return nums[0];
        // 3.nums有两个值及以上的情况
        int[] dp = new int[nums.length];
        // 初始化dp
        dp[0] = nums[0]; // 只有一个数时，最大收益就是nums[0]
        dp[1] = Math.max(nums[0],nums[1]); // 有两个数时，最大收益是两个数中的较大的。
        // 大于两个数时，动态规划进行计算
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        // 最终返回dp[nums.length-1]就是遍历到最后一个nums时的最大收益
        return dp[nums.length-1];
    }
}
