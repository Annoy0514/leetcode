package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 计算将x减少到0的最小操作数 {
//    private static int left = 0;
//    private static int right = 0;
    private static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        System.out.println(getAns(nums,target));
    }
    private static int getAns(int[] nums, int target) {
        int len = nums.length;
        int left = 0,right = 0;
        int maxLength = -1;
        int sum = 0;

        for(int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int count = sum - target;
        if(count < 0) {
            return -1;
        }
        int sumNums = 0;
        while (right < len) {
            sumNums += nums[right];
            while (sumNums > count) {
                sumNums -= nums[left];
                left++;
            }
            if(sumNums == count) {
                maxLength = Math.max(maxLength,right-left+1);
            }
            right++;
        }
        if(maxLength == -1) return -1;
        else return len - maxLength;
    }
}
