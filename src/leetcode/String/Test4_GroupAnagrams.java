package leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test4_GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"abz","zba","edt"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray(); // 将字符串转为字符数组 例:["z","b","a"]
            Arrays.sort(ch); // 例:["a","b","z"]
            String key = String.valueOf(ch); // 将排序好的字符数组转变为字符串，并作为key 例:["a","b","z"]-->"abz"
            if(!map.containsKey(key)){ // 判断Map中是否存在key值对应的Key
                map.put(key,new ArrayList<>()); // 不存在，则将该key值存入到map中，value为新的list
            }
            map.get(key).add(str); // 存在，则将该key对应的字符串添加到key对应的list中
        }
        return new ArrayList<>(map.values()); // 创建一个新的list，存储map中的所有的值，作为返回值返回。
    }
}
