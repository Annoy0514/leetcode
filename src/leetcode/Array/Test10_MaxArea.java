package leetcode.Array;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test10_MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1,1};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int temp = 0;
        while (left < right) {
            // 面积取决于height较低的一侧。
            int area = Math.min(height[left],height[right]) * (right - left);
            // 暂存当前计算的最大值
            temp = Math.max(temp,area);
            /**
             * 双向指针向中间靠拢时，“底” 不断减小，若想找到更大的面积，需要增加 “高”。
             * 分两种情况讨论：
             *      (1) 当左侧小于右侧时，需要将 左指针 向后移动，找到一个比当前值更大的值，作为新的 左侧值。
             *      (2) 当左侧大于右侧时，需要将 右指针 向前移动，找到一个比当前值更大的值，作为新的 右侧值。
             */
            if(height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return temp;
    }
}
