package 笔试;

public class 返回数组中出现一次的数 {
    // 两个相同数字异或=0，一个数和0异或还是它本身。
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,3};
        int len = nums.length;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            res = res ^ nums[i];
        }
        System.out.println(res);
    }
}
