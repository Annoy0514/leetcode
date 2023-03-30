package 高频题;

import java.util.Arrays;
import java.util.Scanner;

public class 插入排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().trim().split(" ");
        int[] nums = new int[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }
        insert(nums);
    }

    private static void insert(int[] nums) {
        // i表示待插入元素的索引
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i]; // 待插入的元素值
            int j = i - 1; // 代表已排序区域的元素索引
            while (j >= 0) {
                if(t < nums[j]) {
                    nums[j+1] = nums[j];
                } else {
                    break; // 退出循环，减少比较次数
                }
                j--;
            }
            nums[j+1] = t;
            System.out.println(Arrays.toString(nums));
        }
    }
}
