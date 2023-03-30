package leetcode.String;

/**
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test3_ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        // 1.首先将两个字符串拆分成字符
        char[] array_s = s.toCharArray();
        char[] array_t = t.toCharArray();
        // 2.创建两个数组用于存储字符串字符出现的频率
        int[] freq_s = new int[26];
        int[] freq_t = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq_s[array_s[i] - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            freq_t[array_t[j] - 'a']++;
        }
        // 3.比较两个字符频率数组中对应位字符出现的频率是否相同
        for (int freq = 0; freq < 26; freq++) {
            if(freq_s[freq] != freq_t[freq]){
                return false;
            }
        }
        return true;
    }
}
