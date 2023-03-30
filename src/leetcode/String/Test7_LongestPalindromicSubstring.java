package leetcode.String;

/**
 * 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */

public class Test7_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "abbc";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n]; // 状态转移记录，dp[i][j]表示从i位置到j位置截断的字符串是否是回文字符串。(true:yes, false:no)
        int maxLen = 0; // 记录最长子串的长度
        int begin = 0; // 记录最长子串的起始位置

        if(s.length() < 2) return s; // 字符串长度为1时，一定为回文字符串，直接返回

        for (int i = 0; i < n; i++) { // 初始化所有长度为1的子串都是回文子串
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int left = n-1; left >= 0; left--) {
            for (int right = left; right < n; right++) {
                if(chars[left] == chars[right]) { // 子串左端等于右端
                    if(right - left <= 1){  // 两种情况(1)0:只含一个字符的字符串 (2)1: 两个字符相同的字符串
                        dp[left][right] = true;
                    } else if(dp[left+1][right-1]){ // 除去两端相同的字符，中间的字符串也是回文子串的情况
                        dp[left][right] = true;
                    }
                }
                if(dp[left][right] && right - left + 1 > maxLen) { // 更新最长的子字符串长度
                    maxLen = right - left + 1;
                    begin = left;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
