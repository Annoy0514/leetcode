package leetcode.位运算;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class Test5_求和_位运算 {
    /**
     * 如果我们的和加上了n，则剩余的问题就是该数字加上【1到n−1的和】，这是一个子问题，因此可以用递归，从n回到1，再累加递归的结果。
     * 需要判断递归停止的条件，即到0时停止递归。
     * 不能使用判断语句，则使用【与运算中的短路操作】：
     */
    public int Sum_Solution(int n) {
        // 通过位运算判断n是否是正数，以结束递归
        boolean flag = (n > 1) && ((n += Sum_Solution(n-1)) > 0);
        return n;
    }
}
