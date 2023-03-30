package leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Test1_Two_Sum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum_hash1(new int[]{2, 7, 11, 5},9)));
    }

    /**
     * 使用暴力破解遍历方法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    /**
     * 使用hash方法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_hash1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if(map.containsKey(res)) {
                // 数组中同一个元素在答案里不能重复出现。
                // [1,9,8,17] ---> 答案应为[0,3] ---> 1+17=18
                // 而不能是[2,2] ---> 重复出现
                if(i != map.get(res)) {
                    return new int[] {i,map.get(res)};
                }
            }
        }
        return new int[] {};
    }
}
