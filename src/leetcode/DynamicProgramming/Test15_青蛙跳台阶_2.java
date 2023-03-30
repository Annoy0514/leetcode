package leetcode.DynamicProgramming;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……【它也可以跳上n级。】
 * 求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
 */

public class Test15_青蛙跳台阶_2 {
    /**
     * 分析如下：
     *  f(1) = 1;
     *  f(2) = f(2-1) + f(2-2);
     *  f(3) = f(3-1) + f(3-2) + f(3-3);
     *  ...
     *  f(n-1) = f(n-1-1) + f(n-1-2) + ... + f(1);
     *  f(n) = f(n-1) + f(n-2) + ... + f(1);
     *
     *  => f(n) = f(n-2) + f(n-3) + ... + f(1) + f(n-2) + f(n-3) + ... + f(1)
     *  => f(n) = 2 * f(n-1) (n >= 2)
     * @param target
     * @return
     */
    public int jumpFloorII(int target) {
        if(target <= 0) {
            return -1;
        } else if(target == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII(target-=1);
        }
    }
}
