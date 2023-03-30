package leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false
 */
public class Test3_ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {2,14,19,22,22};
//        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate_hash(nums));
    }


    public static boolean containsDuplicate(int[] nums) {
        // 先排序，如果存在相同的数字，则两个数必须是邻位
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用hash表，根据hash表的性质，插入元素不可重复
     * @param nums
     * @return
     */
    public static boolean containsDuplicate_hash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer x : nums) {
            if(!set.add(x)) {
//                System.out.println(!set.add(x));
                return true;
            }
        }
        return false;
    }
}
