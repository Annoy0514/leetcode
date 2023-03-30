package leetcode.搜索算法;

/**
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * 给定 target = 3，返回 false。
 */

public class Test2_二维数组中的查找 {

    public boolean Find(int target, int [][] array) {
        /**
         * 二维数组的性质：
         * length是返回二维数组的行数。
         * 数组名[行下标].length 是返回二维数组该行的列数。
         */
        if(array.length == 0) {
            return false;
        }
        int row_num = array.length;
        if(array[0].length == 0) {
            return false;
        }
        int col_num = array[0].length;
        for(int i = row_num-1, j = 0; i >=0 && j < col_num; ) {
            // 比目标值大，则向上走
            if(array[i][j] > target) {
                i--;
            }
            // 比目标值小，则向右走
            else if(array[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
