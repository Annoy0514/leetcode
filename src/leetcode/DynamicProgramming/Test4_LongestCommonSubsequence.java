package leetcode.DynamicProgramming;

/**
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test4_LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "ac";
        System.out.println(longestCommonSubsequence(text1,text2));
    }

    /**
     * 动态规划
     *  状态定义：
     *      二维数组dp[i][j]表示 text1[0:i-1]和 text2[0:j-1]的最长公共子序列。
     *      其中dp[i][j]可以初始化为 0.
     *
     *  状态转移方程：
     *      (1) text1[i-1] == text2[j-1]时，说明二者最后一位相等，故最长公共子序列长度 +1 [就是把最后一位给算上了]
     *          故 dp[i][j] = dp[i-1][j-1] + 1
     *      (2) text1[i-1] != text2[j-1]时，说明二者最后一位不相等，故最长公共子序列应该为 dp[i-1][j]和dp[i][j-1]中的最大值
     *          故 dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     *
     *  初始化：
     *      i = 0或者 j = 0时, dp[i][j] = 0
     *
     *  遍历方向与范围：
     *      后面依赖前面，从小到大。
     *      遍历结束位置：字符串的长度
     *
     *  返回结果:
     *      dp[i][j]计算的是最长公共子序列长度。
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[M][N];
    }
}
