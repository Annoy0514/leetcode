package leetcode.搜索算法;

/**
 * 数字以 0123456789101112131415... 的格式作为一个字符序列，
 * 在这个序列中第 2 位（从下标 0 开始计算）是 2 ，第 10 位是 1 ，第 13 位是 1 ，
 * 以此类题，请你输出第 n 位对应的数字。
 */

public class Test4_数字序列中的某一位的数字 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(30));
    }
    public static int findNthDigit (int n) {
        // write code here
        // 记录n是几位数
        int digit = 1;
        // 记录当前位数区间的起始位置1，10，100...
        long start = 1;
        // 记录当前区间总共有多少位数字
        long sum = 9;
        // 定位n的位置：在某个位数的区间中
        while (n > sum) {
            n -= sum;
            start *= 10;
            digit++;
            // 该区间的总位数
            sum = 9 * start * digit;
        }
        // 定位n在哪个数字上 : 这个区间的起点值加上剩余部分除以这个区间的位数就可以定位n在哪个数字上
        String num = "" + (start + (n-1) / digit);
        // 定位n在数字的哪一位上 : n对位数取模可以定位是哪一位。（下标从0开始，需要对n减1）
        int index = (n - 1) % digit;
        return (int)(num.charAt(index)) - (int)('0');
    }
}
