package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 *
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test9_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    /**
     * 排序 + 双指针
     * 算法流程：
     *      (1) 特例：数组如果为null,或者长度小于3,返回[]；
     *      (2) 对数组进行排序。
     *      (3) 遍历排序后的数组
     *              1) 如果nums[0]>0,由于已经排好序了,则后面不可能有三个数相加得0,直接返回结果。
     *              2) 处理重复元素：跳过，避免重复解。
     *              3) 左指针 left = i+1, 右指针 right = nums.length - 1, left < right时执行循环如下：
     *                  a. 当nums[i] + nums[left] + nums[right] == 0,执行循环，判断左边界和右边界是否和下一位值重复，去除重复解。同时左右移向下一位，寻找新的解。
     *                  b. 若和大于0，表明此时nums[right]太大，right左移。
     *                  c. 若和小于0，表明此时nums[left]太小，left右移。
     *
     * @param nums
     * @return result
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 如果nums为空或是小于3，直接返回[]
        if(nums == null || nums.length < 3) return result;

        // 对数组进行排序
        Arrays.sort(nums);

        // 双指针
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 第一次循环如果nums[0]>0,则三个数字的和一定大于0,所以结束循环
            if(nums[i] > 0) break;

            // 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;  // 去重
                    while (left < right && nums[right] == nums[right-1]) right--; // 去重
                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else if (sum > 0) right--;
            }
        }
        return result;
    }
}
