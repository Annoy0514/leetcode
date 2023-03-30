package leetcode.DynamicProgramming;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 *
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test8_HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int robRange(int[] nums, int start, int end) {
        int a = nums[start]; // 只有一个数时，最大收益就是nums[0]
        int b = Math.max(nums[start],nums[start+1]); // 有两个数时，最大收益是两个数中的较大的。
        // 大于两个数时，动态规划进行计算
        for (int i = start+2; i <= end; i++) {
            int temp = b;
            b = Math.max(a+nums[i],b);
            a = temp;
        }
        // 返回b的值,代表取当前方案下的最后一位时的最大值
        return b;
    }

    public static int rob(int[] nums) {
        // 1.nums只有一个值的情况
        if(nums.length == 1) return nums[0];
        // 2.nums只有两个值的情况
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        // 3.nums有两个值及以上的情况
        /**
         * 将环拆成两种结果:
         *  (1) 取第一位，不取最后一位。[0,nums.length-2]
         *  (2) 取最后一位，不取第一位。[1,nums.length-1]
         *  (3) 分别求两种方案下的最大值，最终取两种情况下的较大的一种。
         */
        return Math.max(robRange(nums,0,nums.length-2),robRange(nums,1, nums.length-1));
    }
}
