package 笔试;

import java.util.HashSet;

public class 最长无重复子序列的长度 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3,2,2};
        System.out.println(getMaxLength(arr));
    }
    public static int getMaxLength (int[] arr) {
        // write code here
        HashSet<Integer> set = new HashSet();
        int l = 0;
        int r = 0;
        int res = 0;
        for (l = 0; l < arr.length; l++) {
            if(l != 0) {
                set.remove(arr[l-1]);
            }
            while (r < arr.length && !set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
            }
            res = Math.max(res,r - l);
        }
        return res;
    }
}
