package leetcode.DynamicProgramming;

/**
 * 在一个 m×n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 如输入这样的一个二维数组，
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 那么路径 1→3→5→2→1 可以拿到最多价值的礼物，价值为12
 */

public class Test19_礼物的最大价值 {
    public int maxValue (int[][] grid) {
        // write code here
        int row = grid.length;
        int col = grid[0].length;
        // 1.第一行数据只能来自左边
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i-1];
        }
        // 2.第一列数据只能来自右边
        for (int j = 1; j < row; j++) {
            grid[j][0] += grid[j-1][0];
        }
        // 3.遍历后续位置
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                // 从来自左边的和来自上边的中取最大值
                grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
    }
}
