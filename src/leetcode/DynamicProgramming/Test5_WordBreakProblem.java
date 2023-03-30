package leetcode.DynamicProgramming;

import java.util.*;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test5_WordBreakProblem {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");
        System.out.println(wordBreak(s,wordDict));
    }


    /**
     * 动态规划：
     *  (1) 状态定义
     *      定义 dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i-1] 是否能 被空格拆分 成若干个字典中出现的单词。
     *
     *  (2) 状态转移方程
     *      使用 j 去划分s[0,i]子串。
     *      s[0,i]子串对应的dp[i+1],它的结果是否为true，取决于以下两点:
     *          1) 它的前缀子串s[0,j-1]的dp[j]，是否为 true
     *          2) 剩余字串s[j,i]，是否是单词表中的单词。
     *
     *  (3) 初始化
     *      定义 dp[s.length + 1]
     *      dp[0] = true : 表示空串为true，只有dp[0]为真，dp[i+1]才能只取决于s[0,i]是否是个单词，才可以用到状态转移方程。
     *
     *  (4) 遍历方向与范围
     *      后面依赖前面，从前往后。
     *      结束位置是字符串的长度。
     *
     *  (5) 返回结果
     *      dp[s.length]表示 s[0,s.length-1]表示的字符串能否被空格拆分成字典中的结果。
     *
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // dp[0] = true : 表示空串为true，只有dp[0]为真，dp[i+1]才能只取决于s[0,i]是否是个单词，才可以用到状态转移方程。
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) { // substring(begin,end) 从begin到end-1的字符串
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
