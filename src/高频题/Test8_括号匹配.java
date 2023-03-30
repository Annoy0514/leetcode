package 高频题;

import java.util.Scanner;
import java.util.Stack;

public class Test8_括号匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='(') stack.push(')');
            else if(c=='{') stack.push('}');
            else if (c=='[') stack.push(']');
            else if(stack.isEmpty() || c!=stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
