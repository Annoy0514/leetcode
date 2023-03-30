package 笔试;

import java.util.Scanner;
import java.util.Stack;

public class 京东_好串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < str.length(); i++){
            if(!stack.isEmpty()&&stack.peek().equals(str.charAt(i))) {
                stack.pop();
                if(stack.peek().equals('a')) {
//                    stack.push('')
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }
        System.out.println(stringBuffer.reverse().toString());
    }
//    public static int getAns()
}
