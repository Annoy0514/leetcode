package 高频题.排序算法;

import java.util.Arrays;
import java.util.Scanner;

public class Test1_选择排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(",");
        int[] nums = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            nums[i] = Integer.valueOf(num[i]);
        }
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            int s = i;
            for (int j = s+1; j < len; j++) {
                if(nums[s] > nums[j]) {
                    s = j;
                }
            }
            if(s != i) {
                swap(nums,s,i);
            }
        }
    }

    public static void selectSort_2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int s = i;
            for (int j = s+1; j < len; j++) {
                if(nums[s] > nums[j]) {
                    s = j;
                }
            }
            if(s != i) {
                swap(nums,s,i);
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
