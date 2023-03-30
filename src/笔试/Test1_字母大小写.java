package 笔试;

import java.util.Scanner;

public class Test1_字母大小写 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println("方法一输出的字符串为：");
        System.out.println(Test1(str,3));
    }
    public static String Test1(String str,int k) {
        String str1="";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if(i < k) {
                char ch=str.charAt(i);
                if((ch>='a'&&ch<='z'))
                {
                    ch=(char)((int)ch-32);
                }
                str1+=ch;
            } else {
                char ch=str.charAt(i);
                if((ch>='A'&&ch<='Z'))
                {
                    ch=(char)((int)ch+32);
                }
                str1+=ch;
            }

        }
        return str1;
    }
}
