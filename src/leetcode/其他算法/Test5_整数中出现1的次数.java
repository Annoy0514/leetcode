package leetcode.其他算法;

/**
 * 输入一个整数 n ，求 1～n 这 n 个整数的十进制表示中 1 出现的次数
 * 例如， 1~13 中包含 1 的数字有 1 、 10 、 11 、 12 、 13 因此共出现 6 次
 * 注意：11 这种情况算两次
 * 题解：https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
 */

public class Test5_整数中出现1的次数 {
    /**
     * 以数字2304为例，若当前位为十位（base = 10），则当前位数0，高位数23，低位数4
     * (1)当前位等于0情况，则可理解有两部分组成0~2299和2300~2304；若固定当前位位1，则前半段组合为[0~22]1[0~9]，次数为230=23*10（high*base）；后半部组合十位只能取0，无法满足固定为1计算前提，次数为0
     *  => res += high * base
     * (2)同理，若数字为2314，当前位等于1情况，优先拆分为0~2299和2300~2314；若固定当前位位1，则前半段组合为[0~22]1[0~9]，次数为230=23*10（high*base）；后半部组合231[0~4]，次数为5（low+1）
     *  => res += (high * base) + low + 1
     * (3)同理，若数字为2324，当前位大于1情况，优先拆分为0~2299和2300~2324；若固定当前位位1，则前半段组合为[0~22]1[0~9]，次数为230=23*10（high*base）；后半部组合231[0~9]，次数为10（base）
     *  => res += (high * base) + base
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int base = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if(cur == 0) res += high * base;
            else if(cur == 1) res += high * base + low + 1;
            else res += high * base + base;
            low += cur * base;
            cur = high % 10;
            high /= 10;
            base *= 10;
        }
        return res;
    }
}
