package leetcode.位运算;

/**
 * 输入一个整数 n ，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */

public class Test2_二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(10));
    }
    /**
     * 数字1与数字相位与运算，其实只是最后一位为1就是1，最后一位为0就是0，
     * 这样我们只需要将数字1移位运算，就可以遍历二进制的每一位，再去做位与运算，结果为1的就是二进制中为1的。
     * &运算中 1&1=1,1&0=0,0&0=0
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int res = 0;
        int yw = 0;
        // 1.遍历二进制的32位，通过移位0-31次实现
        for (int i = 0; i < 32; i++) {
            // 2.将移位后的1与数组进行按位比较(位运算)，结果为1就记录一次
            if((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }
}
