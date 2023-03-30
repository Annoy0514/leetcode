package 笔试;

import java.util.Scanner;

public class 数字马力_test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = sc.nextLine().trim().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }
        System.out.println(getSum(nums,n));
    }

    public static long getSum(int[] nums,int len) {
        long sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] <= nums[i]) {
                    sum += nums[j];
                    sum %= 1000000007;
                }
            }
        }
        return sum;
    }

}
