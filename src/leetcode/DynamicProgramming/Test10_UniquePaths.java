package leetcode.DynamicProgramming;

/**
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test10_UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }


    /**
     * 只能 向下 或者 向右
     * 动态规划:
     *      (1) 状态定义
     *          dp[i][j]表示从[0,0]到[m-1,n-1]的路径数
     *
     *      (2)状态转移方程
     *          1) 从 左边 到达目的地
     *              dp[i][j] = dp[i-1][j]
     *          2) 从 上边 到达目的地
     *              dp[i][j] = dp[i][j-1]
     *          3) 所以总数就为:
     *              dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     *      (3)初始化
     *          1) 若位置在[x,0],则路径dp[x][0] = 1;
     *          2) 若位置在[0,y],则路径dp[0][y] = 1;
     *
     *      (4)遍历的方向
     *          从左到右和从上往下都是递增,故 从小大大.
     *          范围: x:0-m-1, y:0-n-1
     *
     *      (5)返回结果
     *          路径总数
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化只沿着一种方向走的情况
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                dp[x][y] = dp[x-1][y] + dp[x][y-1];
            }
        }
        return dp[m-1][n-1];
    }
}
