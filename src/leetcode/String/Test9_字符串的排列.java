package leetcode.String;
import java.util.*;

/**
 * JZ38 字符串的排列
 *
 * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
 *
 * 具体做法：
 *
 * step 1：先对字符串按照字典序排序，获取第一个排列情况。
 * step 2：准备一个空串暂存递归过程中组装的排列情况。使用额外的vis数组用于记录哪些位置的字符被加入了。
 * step 3：每次递归从头遍历字符串，获取字符加入：首先根据vis数组，已经加入的元素不能再次加入了；
 *         同时，如果当前的元素str[i]与同一层的前一个元素str[i-1]相同且str[i-1]已经用，也不需要将其纳入。
 * step 4：进入下一层递归前将vis数组当前位置标记为使用过。
 * step 5：回溯的时候需要修改vis数组当前位置标记，同时去掉刚刚加入字符串的元素，
 * step 6：临时字符串长度到达原串长度就是一种排列情况。
 */

public class Test9_字符串的排列 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        // 排除特殊情况
        if(str == null || str.length() == 0) {
            return res;
        }
        char[] charStr = str.toCharArray(); // 转字符数组
        Arrays.sort(charStr); // 按照字典顺序排序
        boolean[] vis = new boolean[str.length()]; // 标记每个位置的字符是否被使用过
        Arrays.fill(vis,false);
        StringBuffer temp = new StringBuffer();
        Permu(res, charStr, temp, vis); // 递归获取
        return res;
    }

    private void Permu(ArrayList<String> res, char[] str, StringBuffer temp, boolean[] vis) {
        // 临时字符串满了，加入到结果集中
        if(temp.length() == str.length) {
            res.add(new String(temp));
            return;
        }

        // 遍历所有元素，选取一个加入
        for (int i = 0; i < str.length; i++) {
            // 如果遍历到的元素已经被加入，则跳过
            if(vis[i]) {
                continue;
            }
            // 如果当前元素str[i]与上一位元素str[i-1]相同，并且str[i-1]已经使用过，则跳过
            if(i > 0 && str[i-1] == str[i] && !vis[i-1]) {
                continue;
            }
            // 标记为已经使用过
            vis[i] = true;
            temp.append(str[i]); // 加入到临时字符串中
            Permu(res, str, temp, vis);
            // 回溯
            vis[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
