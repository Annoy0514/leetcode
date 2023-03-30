package leetcode.DynamicProgramming;

public class Test6_CombinationSum {
    public static void main(String[] args) {
        int[] nums = {9};
        int target = 3;
        System.out.println(combinationSum4(nums,target));
    }

    /**
     * 动态规划
     *  (1) 状态定义
     *      dp[x] 表示选取元素之和等于 x 的方案的个数。求的是 dp[target]
     *
     *  (2) 状态转移方程
     *      遍历 i 到 target , 对于每个 i 有：
     *          1) 遍历数组nums中的每个元素，当 num<i 时, 有 dp[i] += dp[i-num] 即最后一位取的是 num 时，target = i-num 的方案数。
     *
     *  (3) 初始化
     *      dp[0] = 1, 表示不选取任何元素时，元素之和为0 ,只有 1 种方案。
     *
     *  (4) 遍历的方向和范围
     *      后面的依赖前面的。从小到大。
     *      范围就是 i从0 -> target
     *
     *  (5) 返回结果
     *      dp[target]表示方案的个数。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num :nums ) {
                if(num <= i){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
