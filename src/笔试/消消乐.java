package 笔试;
import java.util.Scanner;

public class 消消乐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            resovle(strings[i]);
        }
    }

    private static void resovle(String str) {
        StringBuilder stack = new StringBuilder();
        int head = -1;
        int user_id = 0;
        for (int i = 0; i < str.length(); i++) {
            if(stack.length() > 0) {
                if(stack.charAt(head) == str.charAt(i)) {
                    user_id++;
                    stack.deleteCharAt(head);
                    head--;
                    continue;
                }
            }
            stack.append(str.charAt(i));
            head++;
        }
        if(stack.length() == str.length()) {
            System.out.println("No");
        } else {
            if(user_id%2==0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
