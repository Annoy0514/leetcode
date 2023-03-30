package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 联想_test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = 1;
        int fg_nums = 1;
        while (fg_nums != n) {
            boolean[] isFG = new boolean[n];
            int k = 0;
            fg_nums = 0;
            for (int i = 0; i < m; i++) {
                int start = nums[k];
                int end = start+res;
                for(int j = k; j < n && !isFG[j]; j++) {
                    if(start<=nums[j] && nums[j] <= end) {
                        isFG[j] = true;
                        fg_nums++;
                    } else {
                        k = j;
                        break;
                    }
                }
            }
            if(fg_nums == n) {
                System.out.println(res);
            } else {
                res++;
            }
        }
    }
}
