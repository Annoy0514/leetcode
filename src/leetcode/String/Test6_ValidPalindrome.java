package leetcode.String;

import java.util.Stack;

/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * https://leetcode-cn.com/problems/valid-palindrome/
 */

public class Test6_ValidPalindrome {
    public static void main(String[] args) {
        String s = "0p";
        System.out.println(isPalindrome(s));
    }

    /**
     *  回文串: 正序和反序相同。
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        String str_1 = "";
        String str_2 = "";
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] >= 65 && chars[i] <=90) {
                stack.push(chars[i]);
                str_1 += chars[i];
            }
            else if (chars[i] >= 97 && chars[i] <=122) {
                stack.push(chars[i]);
                str_1 += chars[i];
            }
            else if (chars[i] >= 48 && chars[i] <= 57) {
                stack.push(chars[i]);
                str_1 += chars[i];
            }
        }
        while (!stack.isEmpty()){
            str_2 += stack.pop();
        }
        return str_1.toLowerCase().equals(str_2.toLowerCase());
    }

    public static boolean isPalindrome(String s) {
        StringBuffer str_order = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // charAt(index)返回指定索引的字符
            if(Character.isLetterOrDigit(ch)) { // isLetterOrDigit(ch)判断一个字符是字母还是数字。
                str_order.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer str_rev = new StringBuffer(str_order).reverse(); // reverse() 得到反序的字符串
        return str_order.toString().equals(str_rev.toString());
    }
}
