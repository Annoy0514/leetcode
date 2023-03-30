public class Test2_合并数组 {
    public int[] merge (int[] nums1, int m, int[] nums2, int n) {
        // write code here
        int length = nums1.length;

        while (n > 0) {
            if(m > 0 && nums1[m-1] > nums2[n-1]) {
                nums1[--length] = nums2[--m];
            } else {
                nums1[--length] = nums2[--n];
            }
        }
        return nums1;
    }
}
