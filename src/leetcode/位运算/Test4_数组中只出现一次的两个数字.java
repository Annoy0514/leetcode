package leetcode.位运算;

import java.util.HashMap;

/**
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */

public class Test4_数组中只出现一次的两个数字 {

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])) {
                map.put(array[i],1);
            } else {
//                map.put(array[i],map.get(array[i])+1);
                map.remove(array[i]);
            }
        }
        int i = 0;
        for(Integer key : map.keySet()){
            res[i++] = key;
        }
        return res;
    }
}
