package 高频题;


import java.util.Random;

public class Test5_基础排序算法 {
    /**
     * 快速排序
     */
    private final static Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        quickSort(nums, left, right);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex-1);
        quickSort(nums, pivotIndex+1, right);
    }
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right-left+1);
        swap(nums,left,randomIndex);
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while(true) {
            while(le <= ge && nums[le] < pivot) {
                le++;
            }
            while(le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if(le >= ge) {
                break;
            }
            swap(nums,le,ge);
            le++;
            ge--;
        }
        // 退出循环
        swap(nums,left,ge);
        return ge;
    }
    private void swap(int[] nums, int index_1, int index_2) {
        int temp = nums[index_1];
        nums[index_1] = nums[index_2];
        nums[index_2] = temp;
    }
}
