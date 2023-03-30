package 笔试;

import java.util.Scanner;

public class 数字马力_test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        System.out.println(s[s.length-1].length());
    }
}
