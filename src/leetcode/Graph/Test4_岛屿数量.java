package leetcode.Graph;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test4_岛屿数量 {

    public void dfs(char[][] grid, int row, int col) {
        int row_length = grid.length; // 行数
        int col_length = grid[0].length; // 列数

        if(row < 0 || col < 0 || row >= row_length || col >= col_length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row_length = grid.length; // 行数
        int col_length = grid[0].length; // 列数
        int num_island = 0;
        for (int i = 0; i < row_length; i++) {
            for (int j = 0; j < col_length; j++) {
                if(grid[i][j] == '1') {
                    ++num_island;
                    dfs(grid, i, j);
                }
            }
        }
        return num_island;
    }
}
