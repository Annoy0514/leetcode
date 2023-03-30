package leetcode.排序;

import java.util.HashMap;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 */

public class Test1_数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(duplicate(nums));
    }
    public static int duplicate (int[] numbers) {
        int res = 0;
        if(numbers.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(!map.containsKey(numbers[i])) {
                map.put(numbers[i],1);
            } else {
                res = numbers[i];
            }
        }
        return res;
    }
}
