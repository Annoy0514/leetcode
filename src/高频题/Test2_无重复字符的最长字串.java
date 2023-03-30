package 高频题;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */

public class Test2_无重复字符的最长字串 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> subStr = new HashSet<>();
        int len = s.length();
        // 最长无重复子串的长度
        int res = 0;
        // 右边界指针
        int right = -1;
        for (int left = 0; left < len; left++) {
            // 左移,删除左边界的字符
            if(left != 0) {
                subStr.remove(s.charAt(left-1));
            }
            // 右指针右移,并且判断右移后 ①是否包含重复字符 ②是否移到最右端
            while (right + 1 < len && subStr.contains(s.charAt(right+1))) {
                subStr.add(s.charAt(right+1));
                right++;
            }
            // 滑动窗口不停滑动，记录最长无重复子串的长度
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int lenOfLongestSubString(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int right = -1;
        int res = 0;
        for (int left = 0; left < len; left++) {
            if(left != 0) {
                set.remove(s.charAt(left-1));
            }
            while (right+1 < len && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
