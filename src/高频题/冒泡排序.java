package 高频题;

import java.util.Arrays;
import java.util.Scanner;

public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for(int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//        }
        String[] numbers = scanner.nextLine().trim().split(" ");
        int[] nums = new int[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubble(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean swapped = false; // 是否发生交换
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j+1]) {
                    swap(nums, j,j+1);
                    swapped = true;
                }
            }
            if(!swapped) break; // 没有发生交换，则已经排序完成，跳出循环
        }
    }

    public static void swap(int[]nums, int a, int b) {
        int tmp;
        tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
