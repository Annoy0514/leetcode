package leetcode.Binary;

import java.util.HashSet;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */

public class Test4_Missing_Number {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(missingNumber(nums));
    }

    /**
     * 1.使用Hash表解决该问题
     * 先将数组中的数据存入到一个哈希表中，通过哈希表的contains判定是否存在某数字。
     * 例如：[0,1,2],此时长度为3，则应当包含的数字为[0,3]即[0,1,2,3],缺少的数字为3。
     * 因此，在查询的时候，需要从0开始，到3结束。[解释第二个for循环的条件]
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int result = -1;
        for (int num = 0; num <= n; num++) {
            if(!set.contains(num)){
                result = num;
                break;
            }
        }
        return result;
    }
}
