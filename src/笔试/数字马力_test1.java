package 笔试;

import java.util.Scanner;

/**
 * 输入一个字符串，输出字符串中大写字母的个数
 */

public class 数字马力_test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getUpper(str));
    }

    public static int getUpper(String string) {
        int count = 0;
        if(string.length() == 0 || string == null) return 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                count++;
            }
        }
        return count;
    }
}
