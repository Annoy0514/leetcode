package leetcode.其他算法;

import java.util.Arrays;

/**
 * 输入一个长度为 n 整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Test4_调整数组顺序使奇数位于偶数前面_1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(reOrderArray(array)));
    }
    public static int[] reOrderArray (int[] array) {
        int len = array.length;
        int[] tmp_1 = new int[len];
        int[] tmp_2 = new int[len];
        int index_1 = 0,index_2 = 0;
        for (int i = 0; i < len; i++) {
            if(array[i] % 2 != 0) {
                tmp_1[index_1] = array[i];
                index_1++;
            } else {
                tmp_2[index_2] = array[i];
                index_2++;
            }
        }
        for (int i = 0; i < index_2; i++) {
            tmp_1[index_1] = tmp_2[i];
            index_1++;
        }
        return tmp_1;
    }
}
