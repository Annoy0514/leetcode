package 高频题;

import java.util.Arrays;
import java.util.Scanner;

public class 选择排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        selection(nums);
    }

    private static void selection(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // i 表示每轮选择最小元素要交换到的目标索引
            int s = i;
            for (int j = s+1; j < nums.length; j++) {
                if(nums[s] > nums[j]) {
                    s = j;
                }
            }
            if(s != i) {
                swap(nums,s,i);
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp;
        tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
