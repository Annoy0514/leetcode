package leetcode.搜索算法;

import java.util.HashMap;

/**
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 */

public class Test1_数字在升序数组中出现的次数 {
    /**
     * 常规解法
     * @param array
     * @param k
     * @return
     */

    public int GetNumberOfK(int [] array , int k) {
        if(array == null) return 0;
        int count = 0;
        for (int e : array) {
            if(e==k) count++;
        }
        return count;
    }
    /**
     * 高射炮打蚊子解法。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK_2(int [] array , int k) {
        if(array == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])) {
                map.put(array[i],0);
            }
            if(map.containsKey(array[i])) {
                map.put(array[i],map.get(array[i])+1);
            }
        }
        if (map.containsKey(k)) {
            return map.get(k);
        } else return 0;
    }
}
