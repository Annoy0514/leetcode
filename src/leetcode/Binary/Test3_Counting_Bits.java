package leetcode.Binary;

import java.util.Arrays;

/**
 *  给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */

public class Test3_Counting_Bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }


    /**
     * 思路解析：
     *      对于正整数 [x] ,将其二进制表示右移一位，等于将其二进制表示的最低位去掉，得到[x/2](向下取整)。
     *      如果 bits[x/2] 已知，则可以求得 bits[x] 的值：
     *          (1) 如果 x 是偶数，则 bits[x] = bits[x/2]
     *          (2) 如果 x 是奇数，则 bits[x] = bits[x/2] + 1
     *      上述情况合并：
     *          bits[x] = bits[x/2] + x除以2的余数(判定是奇数还是偶数)
     *          bits[x/2] = bits[x >> 1]
     *          x除以2的余数 = (x & 1) 按位与，两位都是1才是1，01,00,10都是0
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] bits = new int[n + 1]; // 默认值都为0
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
