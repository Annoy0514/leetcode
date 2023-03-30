package leetcode.Array;
import java.util.ArrayList;
/**3
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
 *
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 *
 */
public class Test12_最小的K个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        if(k > input.length || k == 0) {
            return res;
        }
        quickSort(input,res,k,0, input.length - 1);
        return res;
    }

    public void quickSort(int[] input, ArrayList<Integer> res, int k, int left, int right) {
        int start = left;
        int end = right;
        while (left < right) {
            // 找到大于基准点的位置
            while (left < right && input[right] >= input[start]) {
                right--;
            }
            // 找到小于基准点的位置
            while (left < right && input[left] <= input[start]) {
                left++;
            }
            Swap(input, left, right); // 交换两个位置的值
        }

        Swap(input, left, start); // 交换基准点与左右指针相遇位置的值，此时，左右指针相遇位置左边全是小于该位置值，右边全是大于该位置的值

        /**
         * 题目说明可以【无序】
         */

        // 当左右两个指针相遇的位置index，大于 k 时，表示相遇位置(index)之前的值都小于该位置(index)的值，此时快排(start-->index)之间的数据即可
        if(left > k) {
            quickSort(input, res, k, start, left - 1);
        } else if(left < k) { // 当左右两个指针相遇的位置index，小于 k 时，相遇位置(index)之前的值都小于该位置(index)的值，还需快排(index-->end)之间的数据即可
            quickSort(input, res, k, left + 1, end);
        } else { // 输出前k个值
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
        }
    }

    public void Swap(int[] arr, int r, int l) {
        if(r == l) return;
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }
}
