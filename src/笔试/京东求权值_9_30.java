package 笔试;

import java.util.Scanner;

public class 京东求权值_9_30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNums(n));
    }

    private static int getNums(int n) {
        int res = 26;
        for (int i = 1; i < n; i++) {
            res *= 25;
        }
        return (int)(res%(Math.pow(10,9)+7));
    }

    private static int getQuanzhi(String str) {
        int res = 0;
        char[] strs = new char[str.length()];
        int i = 0;
        for(char c : str.toCharArray()) {
            strs[i] = c;
            i++;
        }
        for (int j = 0; j < strs.length-1; j++) {
            if(strs[j] != strs[j+1]) {
                res++;
            } else {
                continue;
            }
        }
        return res;
    }
}
