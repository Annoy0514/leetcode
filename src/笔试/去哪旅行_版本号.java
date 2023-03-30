package 笔试;

import java.util.Scanner;

public class 去哪旅行_版本号 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = "0.1.apl";
        String str2 = "1.over";
        System.out.println(CompareStr(str1,str2));
    }

    public static int CompareStr(String str1, String str2) {
        String[] str_1 = str1.split("\\.");
        String[] str_2 = str2.split("\\.");
        int len = str1.length() < str2.length() ? str_1.length : str_2.length;
        int i = 0;
        while (i < len) {
            if(Integer.valueOf(str_1[i]) > Integer.valueOf(str_2[i])) return 1;
            else if(Integer.valueOf(str_1[i]) < Integer.valueOf(str_2[i])) return -1;
            else i++;
        }
        return 0;
    }
}
