package leetcode.DynamicProgramming;

/**
 *
 */

public class Test17_矩形覆盖 {
    /**
     * 问题抽象还是 【斐波那契数列】 。
     *  1.约定n==0时，输出0;
     *  2.n==1时，只有1种情况。
     *  3.n==2时，有2中情况。
     *  4.n>2时，f(n) = f(n-1) + f(n-2);
     *      * 直接在n=3的情况下，再后面中添加一个竖着的。这个很显然成立，有3种情况.
     *      * 然后横着的显然能添加到n-2的情况上，也就是在n=2后面，添加2个横着的。有2种情况
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if(target <= 2) {
            return target;
        } else {
            return rectCover(target - 1) + rectCover(target - 2);
        }
    }
}
