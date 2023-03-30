package 高频题;

import java.util.Scanner;

public class Test7_快速幂 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 1;
        while (b > 0) {
            // Java中关系运算符优先级大于逻辑运算符
            // &左右是布尔类型时会进行布尔运算，否则进行位运算。
            if((b&1)>0) {
                ans *= a; // ans乘上当前的a
            }
            a *= a; // a自乘
            b >>= 1; // b右移一位相当于除以2
        }
        System.out.println(ans);
    }
}
