package leetcode.Interval;

import java.util.Arrays;

/**
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test3_NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 ){
            return 0;
        }
        // 按照 右端点 升序排序
        // 最早结束的区间，后面才会有更多的区间等待判断
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int R = intervals[0][1];
        int n = 1; // 至少可以有一个没有交集的区间
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= R) { // 当遍历到的区间的左端点大于 R 时，表示该区间与上一个区间没有交集
                ++n; // 记录没有交集的区间数
                R = intervals[i][1];
            }
        }
        return intervals.length - n; // 返回结果就是需要移除的最大区间数量
    }
}
