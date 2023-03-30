package 笔试;

import java.util.Scanner;

public class 组队 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(makeGroup(nums,x,y));
    }

    private static int makeGroup(int[] nums, int x, int y) {
        boolean[][] group = new boolean[nums.length][nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] >= x && nums[i] * nums[j] >= y) {
                    group[i][j] = true;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(group[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
