package leetcode.Array;

import java.util.Arrays;

/**
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 *
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 *
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test4_ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {4,5,1,8,2};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // 拆成两个部分：左侧和右侧
        // 1.左侧
        int[] L = new int[nums.length];
        // 2.右侧
        int[] R = new int[nums.length];
        // 结果集
        int[] answer = new int[nums.length];

        /**
         * 左侧部分
         * L[0] 代表num[0]左侧数据的乘积
         * 由于num[0]左侧没有数据，则 L[0]=1
         */
        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i-1] * L[i-1];
        }

        /**
         * 右侧部分
         * R[length-1]代表num[length-1]右侧数据的乘积
         * 由于num[length-1]右侧没有数据，则 R[length-1]=1
         */
        R[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            R[i] = nums[i+1] * R[i+1];
        }

        /**
         * 乘积部分
         * 除num[i]以外其余数据的乘积为
         * L[i] * R[i]
         */
        for (int i = 0; i < nums.length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    /**
     * 优化空间复杂度
     * 由于输出数组不算在空间复杂度内，那么我们可以将 L 或 R 数组用输出数组来计算。
     */
    public int[] productExceptSelf_2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }
}
