package leetcode.排序;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。
 * 即输出P mod 1000000007
 * 如数组{7,5,6,4}，逆序对总共有5对，{7,5}，{7,6}，{7,4}，{5,4}，{6,4}；
 */

public class Test2_数组中的逆序对 {
    /**
     * 处理思路：
     *  (1)先把数组分割成子数组，统计出子数组内部的逆序对数目。
     *  (2)再统计出两个相邻子数组之间的逆序对的数目。在统计逆序对的过程中，还需要对数组进行排序。
     *  (3)归并排序：分治
     */
    public int mod = 1000000007;
    public int mergeSort(int left, int right, int[] data, int[] temp) {
        // 停止划分
        if(left >= right) {
            return 0;
        }
        // 取中间
        int mid = (left + right) / 2;
        // 左右划分合并
        int res = mergeSort(left,mid,data,temp) + mergeSort(mid+1,right,data,temp);
        // 防止溢出
        res %= mod;
        int i = left, j = mid + 1;
        for(int k =left; k <= right; k++){
            temp[k] = data[k];
        }
        for(int k = left; k <= right; k++) {
            if(i == mid + 1) {
                data[k] = temp[j++];
            }
            else if(j == right + 1 || temp[i] <= temp[j]) {
                data[k] = temp[i++];
            }
            else {
                data[k] = temp[j++];
                res += mid - i + 1;
            }
        }
        return res % mod;
    }
    public int InversePairs(int [] array) {
        int n = array.length;
        int[] res = new int[n];
        return mergeSort(0, n-1, array ,res);
    }
}
