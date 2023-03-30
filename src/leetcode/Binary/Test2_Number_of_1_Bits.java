package leetcode.Binary;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 */

public class Test2_Number_of_1_Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            // 把n和1做运算，判断n的最低位是不是1，
            // 接着把1左移一位得到2，再和n做运算，就能判断n的次低位是不是1
            if((n & (1 << i)) != 0) {
                count ++;
            }
        }
        return count;
    }
}
