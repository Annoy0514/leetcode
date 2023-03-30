package leetcode.位运算;

/**
 * 实现函数 double Power(double base, int exponent)，求base的exponent次方。
 * 注意：
 * 1.保证base和exponent不同时为0。
 * 2.不得使用库函数，同时不需要考虑大数问题
 * 3.有特殊判题，不用考虑小数点后面0的位数。
 *
 */

public class Test3_数值的整数次方 {
    public double Power(double base, int exponent) {
        // 1.处理次方数为负数的情况：将底化成分数即可
        if(exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double res = 1.0;
        // 2.进行累乘
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }
}
