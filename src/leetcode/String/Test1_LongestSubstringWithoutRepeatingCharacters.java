package leetcode.String;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

public class Test1_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口
     *  (1) 参数定义
     *      左指针: 枚举字符串的起始位置.
     *      右指针: 枚举字符串的终止位置.
     *
     *  (2) 处理流程:
     *      1) 每次操作先将左指针向后移动一个单位,表示开始枚举下一个字符作为起始位置.
     *      2) 每次左指针右移之后的当此循环中,右指针开始不断右移,不断将不重复的字符添加到子串中.
     *      3) 左移循环结束后,得到的子串就是 以左指针为起始位置,不包含重复的字符的最长子串.
     *      4) 最终返回最长字串的长度.
     *
     * 需要使用一种数据结构来判断 是否有重复的字符，常用的数据结构为 哈希集合(HashSet)
     *
     * @param s
     * @return
     */

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> substr = new HashSet<Character>();
        int n = s.length();
        int right = -1; // right = -1相当于在左边界的左侧,表示 此时并没有移动
        int subStrLength = 0; // 代表最长子串的长度
        for (int left = 0; left < n; left++) {
            if(left != 0) {
                // 左移,删除左边界的字符
                substr.remove(s.charAt(left - 1));
            }
            // 右指针右移,并且判断右移后①是否包含重复字符 ②是否移到最右端
            while (right + 1 < n && !substr.contains(s.charAt(right+1))) {
                // 将新的字符加入到子串中
                substr.add(s.charAt(right + 1));
                right++;
            }
            // 滑动窗口不停滑动,将最长的子字符串长度求出
            subStrLength = Math.max(subStrLength, right - left + 1);
        }
        return subStrLength;
    }
}
