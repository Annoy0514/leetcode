package leetcode.Binary;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 */

public class Test1_SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(-999,0));
    }

    /**
     * 通过 位运算 进行处理
     * (1) a+b的问题拆分成，a和b无进位的结果和a和b的进位结果。
     * (2) 无进位加法使用 异或运算 计算得出。
     * (3) 进位结果使用 与运算 和 移位运算 计算得出
     * (4) 循环此过程，直到进位为 0
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        while (b!=0) {
            int temp = (a & b) << 1;  // 将所有的二进制位的值向左移动若干位，高位舍弃，低位补零。
            a = a ^ b;  // 异或运算(相同为0，相异为1)
            b = temp;
        }
        return a;
    }
}
