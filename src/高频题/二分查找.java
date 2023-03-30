package 高频题;

import java.util.Arrays;
import java.util.Scanner;

public class 二分查找 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(binarySearch(nums,target));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int m;
        while (left < right) {
            m = (left + right) / 2;
            if(nums[m] == target) {
                return m;
            } else if(nums[m] < target) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return -1;
    }
}
