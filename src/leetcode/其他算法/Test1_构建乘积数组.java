package leetcode.其他算法;
import java.util.*;
import java.util.ArrayList;

/**
 * 给定一个数组 A[0,1,...,n-1] ,请构建一个数组 B[0,1,...,n-1] ,
 * 其中 B 的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]（除 A[i] 以外的全部元素的的乘积）。
 * 程序中不能使用除法。（注意：规定 B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2]）
 * 对于 A 长度为 1 的情况，B 无意义，故而无法构建，用例中不包括这种情况。
 *
 * 题解：https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
 */

public class Test1_构建乘积数组 {
    public int[] multiply(int[] A) {
        int len = A.length;
        if(len == 0) return new int[0];
        int[] B = new int[len];
        B[0] = 1;
        int tmp = 1;
        // 计算下三角
        for (int i = 1; i < len; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        // 计算上三角
        for (int i = len - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }
        return B;
    }
}
