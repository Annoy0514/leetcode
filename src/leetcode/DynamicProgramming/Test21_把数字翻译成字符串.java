package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * 我们把一个字符串编码成一串数字，再考虑逆向编译成字符串。
 * 由于没有分隔符，数字编码成字母可能有多种编译结果，例如 11 既可以看做是两个 'a' 也可以看做是一个 'k' 。
 * 但 10 只可能是 'j' ，因为 0 不能编译成任何结果。
 * 现在给一串数字，返回有多少种可能的译码结果
 */

public class Test21_把数字翻译成字符串 {
    /**
     * 动态规划法：
     *  1.使用辅助数组dp表示前i个数的译码方式有多少种。
     *  2.对于一个数，可以直接对他译码，也可以将其与前面的1或者2组合起来译码。
     *      如果直接译码，则dp[i] = dp[i-1];
     *      如果组合译码，则dp[i] = dp[i-2];
     *  3.对于只有一种译码方式，dp[i-1]；对于有两种译码方式(排除10和20),为dp[i-1] + dp[i-2]
     *  4.返回结果dp[length]就是有多少种可能的译码方式。
     * @param nums
     * @return
     */
    public int solve (String nums) {
        // 1.数字为0的情况
        if(nums.equals("0")) {
            return 0;
        }
        // 2.数字为10或20的情况
        if(nums.equals("10") || nums.equals("20")) {
            return 1;
        }
        // 3.当0前面一位数字不是1或0时，无法译码，返回0
        for(int i = 1; i < nums.length(); i++) {
            if(nums.charAt(i) == '0') {
                if(nums.charAt(i-1) != '1' && nums.charAt(i-1) != '2') {
                    return 0;
                }
            }
        }
        int[] dp = new int[nums.length() + 1];
        // 辅助数组初始化为1
        Arrays.fill(dp,1);
        for(int i = 2; i <= nums.length(); i++) {
            // 4.11-19和21-26之间的情况
            if(nums.charAt(i - 2) == '1' && nums.charAt(i-1) != '0' || nums.charAt(i - 2) == '2' && nums.charAt(i-1) > '0' && nums.charAt(i-1) < '7') {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length()];
    }
}
