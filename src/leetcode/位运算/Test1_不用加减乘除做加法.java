package leetcode.位运算;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Test1_不用加减乘除做加法 {
    public static void main(String[] args) {
        System.out.println(Add(5,7));
    }
    /**
     * 不可以用加减乘除，所以可以用 与或非运算。
     * (1) 不算进位：二进制每位相加就相当于各位做 【异或操作：同值取0，异值取1】.
     * (2) 算进位：相当于各位做【与操作：同1取1，同0取0，异值取0，再向左移一位】。
     * 具体做法：
     *  (1) 两个数进行 [与运算] 可以产生进位的信息
     *  (2) 运算后执行 [左移一位] 就是每轮需要进位的方案
     *  (3) 两数进行 [异或运算] 可以产生非进位的加和结果
     *  (4) 将 [移位后的进位结果] 和 [非进位结果] 继续重复(1)-(3)的步骤，直到不再产生进位为止。[进位值为0，跳出循环]
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1,int num2) {
        // add表示进位值
        int add = num2;
        // sum表示总和
        int sum = num1;
        // 不再有进位时终止循环
        while (add != 0) {
            // 将每轮的无进位与进位值做异或求和
            int temp = sum ^ add;
            // 进位值是用与运算产生的
            add = (sum & add) << 1;
            // 更新sum为新的和
            sum = temp;
        }
        return sum;
    }
}
