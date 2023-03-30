package leetcode.其他算法;

import java.util.HashMap;

/**
 * 在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */

public class Test2_第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 统计每个字符出现的次数
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        // 找到第一个只出现一次的字符
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        // 没有找到
        return -1;
    }
}
