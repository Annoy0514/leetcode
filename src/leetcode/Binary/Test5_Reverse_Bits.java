package leetcode.Binary;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */

public class Test5_Reverse_Bits {
    public static void main(String[] args) {

    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; ++i) { // 一直循环，直到n为0(n中每一位都取出了)
            result |= (n & 1) << (31 - i); // 取出n的最后一位后，向左移31-i位,将其加入到result中。
            n >>>= 1; // n向右移动一位(java中需要进行逻辑右移)
        }
        return result;
    }
}
