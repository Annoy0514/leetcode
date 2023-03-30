package leetcode.String;

/**
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 *
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test2_LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "ADDDSERRTERRRRRRF";
        int k = 3;
        System.out.println(characterReplacement(s,k));
    }

    /**
     * 双指针(滑动窗口)：
     *      (1) 首先右边界先移动到一个满足要求的，可以替换 k 次以后，所有字符都一样长的最长子串。一直到右边界加入下一个字符，不能满足条件时停下。
     *      (2) 开始移动左边界。左边界移动以后，右边界也可以再次开始向右移动了。
     *      (3) 最长可替换字符的子串就在移动过程中产生。
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // 维护一个字符出现频率的数组(A-Z长度为26)
        int left = 0; // 定义左指针
        int right = 0; // 定义右指针
        char[] Array = s.toCharArray(); // 将字符串转化成字符数组
        int maxCount = 0; // 定义字符出现的最大频率数
        int temp = 0; // 定义最长子串的长度

        while (right < s.length()) { // 移动右边界
            freq[Array[right] - 'A']++; // 字符频率
            maxCount = Math.max(maxCount, freq[Array[right] - 'A']);
            right++; // 右指针右移
            if(right - left > maxCount + k) { // 当可替换次数不够用时
                // 这时需要左指针右移
                freq[Array[left] - 'A']--;  // 原先左指针对应的字符频率 - 1
                left++;
            }
            temp = Math.max(temp, right - left);
        }
        return temp;
    }
}
