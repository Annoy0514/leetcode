package 笔试;

import java.util.ArrayList;
import java.util.List;

public class Test2_坐标 {
    public static void main(String[] args) {
        String s = "123";
        System.out.println(ambiguousCoordinates(s));
    }
    public static List<String> ambiguousCoordinates (String S) {
        // write code here
        String s = "(" + S + ")";
        List<String> strs = new ArrayList<>();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i < s.length(); ++i) {
            for(String left : resolve(s,1,i)) {
                for(String right:resolve(s,i,s.length()-1)) {
                    strs.add(left + "," + right);
                }
            }
        }
        for (String str : strs) {
            ans.append(str+',');
        }
        System.out.println(ans.toString());
        return strs;
    }

    public static List<String> resolve(String s, int left, int right) {
        List<String> strings = new ArrayList<>();
        for (int i = 1; i <= right - left; ++i) {
            String l_index = s.substring(left,left+i);
            String r_index = s.substring(left+i,right);
            if((!l_index.startsWith("0") || l_index.equals("0")) && !r_index.endsWith("0")) {
                strings.add(l_index + (i < right-left ? "." : "") + r_index);
            }
        }
        return strings;
    }
}
