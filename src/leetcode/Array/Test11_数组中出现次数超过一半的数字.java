package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class Test11_数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if(!map.containsKey(i)) { // 如果没有该健，则将该键添加到map中，次数初始化为1次
                map.put(i,1);
            } else {
                map.put(i, map.get(i)+1); // 存在该键时，在value基础上+1
            }
            if(map.get(i) > array.length / 2) { // 大于长度的1/2返回结果
                return i;
            }
        }
        return 0;
    }
}
