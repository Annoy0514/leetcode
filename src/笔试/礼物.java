package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 礼物 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        findMin(nums);
    }

    private static void findMin(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-2; i++) {
            if(nums[i] > nums[i+2]) {
                swap(i,i+2,nums);
            }
        }
        for (int i = 0; i < len-1; i++) {
            if(nums[i] > nums[i+1]) {
                swap(i,i+1,nums);
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static void findMin_2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            boolean isJ = nums[i] % 2 != 0;
            int temp = i;
            for (int j = 0; j < len; j++) {
                if(isJ && nums[j] % 2 == 0 && nums[j] < nums[temp]){
                    temp = j;
                }
                if(!isJ && nums[j] % 2 != 0 && nums[j] < nums[temp]) {
                    temp = j;
                }
            }
            int p = nums[i];
            nums[i] = nums[temp];
            nums[temp] = p;
        }
        for (int num : nums) {
            System.out.println(num+" ");
        }
    }
}
