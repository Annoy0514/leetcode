package leetcode.String;

/**
 * 647. 回文子串
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test8_PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];  // 状态转移记录，dp[i][j]表示从i位置到j位置截断的字符串是否是回文字符串。(true:yes, false:no)
        char[] chars = s.toCharArray();
        int count = 0;

        for (int left = len - 1; left >= 0; left--) {
            for (int right = left; right < len; right++) {
                if(chars[left] == chars[right]) {
                    if(right - left <= 1) {
                        dp[left][right]=true;
                        count++;
                    }
                    else if(dp[left+1][right-1]) {
                        dp[left][right]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
