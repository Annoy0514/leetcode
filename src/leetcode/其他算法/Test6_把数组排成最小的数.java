package leetcode.其他算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个非负整数数组numbers，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组[3，32，321]，则打印出这三个数字能排成的最小数字为321323。
 * 1.输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 2.拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */

public class Test6_把数组排成最小的数 {
    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
    public static String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        String res = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) { // 同号递增，异号递减
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        for (Integer a : list) {
            res += a;
        }
        return res;
    }
}
