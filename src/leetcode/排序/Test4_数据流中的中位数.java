package leetcode.排序;

import java.util.ArrayList;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */

public class Test4_数据流中的中位数 {
    // 1.使用一个数组存储数据流
    private ArrayList<Integer> val = new ArrayList<>();
    // 2.向数组中插入元素
    public void Insert(Integer num) {
        if(val.isEmpty()) {
            // 没有数据直接添加
            val.add(num);
        } else {
            // 有数据，需要插入排序
            int i = 0;
            // 遍历找到插入点
            for (; i < val.size(); i++) {
                if(num <= val.get(i)) {
                    break;
                }
            }
            // 插入相应位置
            val.add(i,num);
        }
    }
    // 获取中位数
    public Double GetMedian() {
        int n = val.size();
        // 数组中元素个数为奇数,返回中间数
        if(n % 2 == 1) {
            return (double)val.get(n/2);
        } else {
            // 数组中元素为偶数，返回中间两个数的平均数
            double a = val.get(n / 2);
            double b = val.get(n / 2-1);
            return (a+b) / 2;
        }
    }
}
