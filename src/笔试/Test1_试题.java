package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class Test1_试题 {
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
        int[] nums = new int[questions.length];
        for (int i : questions) {
            nums[i]++;
        }
        int count = 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            res += 1;
            if(count >= questions.length/4) break;
        }
        return res;
    }
}
