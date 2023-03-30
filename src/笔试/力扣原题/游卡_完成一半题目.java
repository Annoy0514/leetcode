package 笔试.力扣原题;

import java.util.Arrays;
import java.util.Scanner;

public class 游卡_完成一半题目 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }
        System.out.println(halfQuestions(nums));
    }

    public static int halfQuestions(int[] questions) {
        int[] nums = new int[1001];
        for (int i : questions) {
            nums[i]++;
        }
        int count = 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0; i--) {
            count += nums[i];
            res++;
            if(count >= questions.length/2) break;
        }
        return res;
    }
}
