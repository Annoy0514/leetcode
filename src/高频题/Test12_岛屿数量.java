package 高频题;

public class Test12_岛屿数量 {
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int row_length = grid.length;
        int col_length = grid[0].length;
        int island_num = 0;
        for (int i = 0; i < row_length; i++) {
            for (int j = 0; j < col_length; j++) {
                if(grid[i][j] == '1') {
                    island_num++;
                    dfs(grid,i,j);
                }
            }
        }
        return island_num;
    }

    // 感染函数：首先找到一个坐标值为1的点，然后进行深度优先遍历，把临近的点的1全变成0
    public static void dfs(char[][] grid, int row, int col) {
        int row_length = grid.length;
        int col_length = grid[0].length;

        if(row < 0 || col < 0 || row >= row_length || col >= col_length ||grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid,row - 1,col);
        dfs(grid,row + 1,col);
        dfs(grid,row,col - 1);
        dfs(grid,row,col + 1);
    }
}
