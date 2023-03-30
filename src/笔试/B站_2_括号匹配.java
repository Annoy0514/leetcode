package 笔试;

import java.util.Scanner;
import java.util.Stack;

public class B站_2_括号匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stackChs = new Stack<>();
        Stack<Integer> stackIdx = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '[') {
                stackChs.push(']');
            } else if(ch=='{') {
                stackChs.push('}');
            } else if(ch == '(') {
                stackChs.push(')');
            } else if(stackChs.isEmpty() || stackChs.peek()!=ch) {
                if(stackChs.isEmpty()) {
                    switch (ch) {
                        case ']':
                            System.out.println("[,"+(i+1));
                            break;
                        case '}':
                            System.out.println("{,"+(i+1));
                            break;
                        case ')':
                            System.out.println("(,"+(i+1));
                            break;
                    }
                }
                if(stackChs.peek()!=ch) {
                    System.out.println(stackChs.pop()+","+(i+1));
                    i--;
                }
            }
            else {
                stackChs.pop();
            }
            if(!stackChs.isEmpty()) {
                System.out.println(stackChs.pop()+","+str.length()+1);
            }
        }
    }
}
