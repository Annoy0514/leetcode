package leetcode.DynamicProgramming;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：'A' -> "1" 'B' -> "2"...'Z' -> "26"
 *
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test9_DecodeWays {
    public static void main(String[] args) {
        String s = "0";
        System.out.println(numDecodings(s));
    }

    /**
     * 思想跟 爬楼梯 类似
     * 动态规划
     *      (1)状态定义
     *          dp[i]表示包含第i位时，可以解码的方法的总数。
     *
     *      (2)状态转移方程
     *          dp[i]记录以字符串 s 的中前 i 位字符的解码方案数。dp[1]代表从s的第一位开始解码的方案个数.
     *              1) 当前位置 i 可单独被解码，此时 i 的取值范围为[1,9]。
     *                  转移逻辑为: dp[i] = dp[i-1]
     *              2) 当前位置 i 不可单独被解码，需要和前一位 i-1 共同解码时，此时 i i+1组成的大小为[10,26]
     *                  转移逻辑为: dp[i] = dp[i-2]
     *              3) 当前位置既可以单独被解码，又可以和前一位组合解码
     *                  转移逻辑为: dp[i] = dp[i-1] + dp[i-2]
     *
     *      (3)初始化
     *          dp[s.length + 1]
     *          dp[0] = 1,设置边界条件
     *
     *      (4)遍历的方向
     *          后面的取决于前面的，从前往后
     *          遍历的范围到 s.length
     *
     *      (5)返回结果
     *          可以解码的方法的总数。
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        String temp = " " + s;
        char[] cs = temp.toCharArray();
        // 设置边界条件
        dp[0] = 1;
        for(int i = 1; i <= s.length(); i++ ) {
            // a 表示当前位可以被解码的情况
            int a = cs[i] - '0';
            // b 表示当前位和前一位组合在一起才能被解码的情况
            int b = (cs[i-1] - '0') * 10 + cs[i] - '0';
            if(1 <= a && a <=9) dp[i] = dp[i-1];
            if(10 <= b && b <= 26) dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}
