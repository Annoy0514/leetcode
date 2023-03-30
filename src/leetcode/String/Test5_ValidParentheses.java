package leetcode.String;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test5_ValidParentheses {
    public static void main(String[] args) {
        String s = "{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        // 1.当字符串的长度为奇数时，一定存在不匹配的符号
        if(s.length() % 2 == 1) return false;

        // 2.使用 栈 数据结构处理该问题
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] == '(') stack.push(')');
            else if (chars[i] == '[') stack.push(']');
            else if (chars[i] == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop()!=chars[i]) return false; // 判断条件短路，stack.pop()将栈顶元素弹出
        }
        return stack.isEmpty(); // (1)stack为空代表完全匹配。 (2)不为空代表存在没有匹配的。
    }
}
