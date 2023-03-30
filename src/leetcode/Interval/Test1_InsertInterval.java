package leetcode.Interval;

import java.util.ArrayList;
import java.util.Arrays;

public class Test1_InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {18,30};
        System.out.println(Arrays.deepToString(insert(intervals,newInterval)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean flag = false;
        ArrayList<int[]> ansList = new ArrayList<>();

        for (int[] interval : intervals) {
            if(interval[0] > right) { // 在插入区间的右边
                if(!flag) {
                    ansList.add(new int[] {left,right}); // 先把 中间区间 的插入
                    flag = true;
                }
                ansList.add(interval); // 再将 中间区间右边  的插入
            } else if (interval[1] < left) { // 在插入区间的左边
                ansList.add(interval);
            } else { // 存在交集
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if(!flag) {
            ansList.add(new int[] {left,right});
        }
        int[][] result = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            result[i] = ansList.get(i);
        }
        return result;
    }
}
