package leetcode.DynamicProgramming;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * https://leetcode-cn.com/problems/jump-game/
 */

public class Test11_JumpGame {
    public static void main(String[] args) {
        int[] nums = {6,0,0,0,0,0,0,6};
        System.out.println(canJump(nums));
    }


    /**
     * 从后向前遍历,如果该节点可以跳到最终位置end_1,则将该节点设置为最终位置end_2,继续向前遍历,查找前面是否有满足能跳到end_2.
     * 循环这种查询,直到初始位置.即 end_x == 0 ? true : flase
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = end; i >= 0; i--) {
            if(nums[i] + i >= end) {
                end = i;
            }
        }
        return end==0;
    }
}
