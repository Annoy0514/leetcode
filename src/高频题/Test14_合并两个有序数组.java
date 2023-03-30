package 高频题;

import java.util.Arrays;

public class Test14_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i != n; ++i) {
            nums1[n+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
