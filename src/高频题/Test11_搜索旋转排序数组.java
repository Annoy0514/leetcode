package 高频题;

import java.util.Arrays;
import java.util.Scanner;

public class Test11_搜索旋转排序数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int target = sc.nextInt();
        String[] split = str.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        System.out.println(search(nums,target));
    }

    private static int search(int[] nums, int target) {
        // 1.长度为0的情况
        if(nums.length == 0 || nums == null) return -1;

        // 2.长度为1的情况
        if(nums.length == 1) {
            if(nums[0] == target) return 0;
            else return -1;
        }

        // 3.其他长度,二分查找
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target <= nums[nums.length-1] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
