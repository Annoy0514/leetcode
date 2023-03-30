package leetcode.DynamicProgramming;

/**
 * 大家都知道斐波那契数列，现在要求输入一个正整数 n ，请你输出斐波那契数列的第 n 项。
 */

public class Test16_斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }
    public static int Fibonacci(int n) {
        if(n == 1 || n == 2) {
            return 1;
        } else {
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
}
