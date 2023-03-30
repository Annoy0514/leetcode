package 高频题;

public class Test15_回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0; // 记录最长子串的长度
        int begin = 0; // 记录最长子串的起始位置

        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // 初始化，长度为1的字符串都是回文子串
        }

        char[] chars = s.toCharArray();
        for(int left = n-1; left >=0; left--) {
            for(int right = left; right < n; right++) {
                if(chars[left]==chars[right]) {
                    if(right - left <= 1) { // 1:两个相同的字符 0:一个字符
                        dp[left][right] = true;
                    } else if(dp[left+1][right-1]) { // 抛去两端字符，中间的子字符串仍是回文子串，则加上两端字符仍是回文字符串
                        dp[left][right] = true;
                    }
                }
                if(dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    begin = left;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
