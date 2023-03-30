package leetcode.DynamicProgramming;

import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 输入：
 * "abcabcbb"
 * 返回值：
 * 3
 * 说明：
 * 因为无重复字符的最长子串是"abc"，所以其长度为 3。
 */

public class Test20_最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring (String s) {
        // 1.使用哈希表，记录字符出现的次数
        HashMap<Character, Integer> mp = new HashMap<>();
        int res = 0; // 记录最长非重复元素字串的长度
        // 2.使用滑动窗口，记录子串
        for(int left = 0,right = 0; right < s.length(); right++) {
            // 窗口右指针遍历到的元素，进入哈希表查询，统计出现次数
            if(mp.containsKey(s.charAt(right))) {
                mp.put(s.charAt(right),mp.get(s.charAt(right)) + 1);
            } else {
                mp.put(s.charAt(right),1);
            }
            // 当字符出现次数大于1时，窗口有重复
            while (mp.get(s.charAt(right)) > 1) {
                // 窗口向左移动，同时减去该字符出现的次数
                mp.put(s.charAt(left),mp.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1); // 更新最长的长度
        }
        return res;
    }
}
