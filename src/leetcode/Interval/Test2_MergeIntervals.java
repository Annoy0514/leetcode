package leetcode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 *
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test2_MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,6},{3,5},{6,7},{8,10},{12,16}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }


    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        ArrayList<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            // 1.遍历到的区间 在结果集中最后一项的右侧(与结果集不重合，直接添加到结果集)
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L,R});
            } else { // 2.遍历到的区间 与结果集中的区间有交集
                // 将右侧的较大值赋给结果集中的项
                merged.get(merged.size()-1)[1] = Math.max(R,merged.get(merged.size()-1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
