package leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

public class Test3_大西洋太平洋问题 {

    /**
     *  深度优先 dfs
     *      从一个单元格开始，通过搜索的方法模拟雨水的流动，则可以判断雨水是否可以从该单元格流向海洋。
     *      从矩阵边界 反向搜索 寻找雨水流向边界的单元格，反向搜索时，每次只能移动到高度相同或是更大的单元格。
     *      (1) 太平洋：左边界和上边界。从这两个边界搜索可以找到能够流向太平洋的点。
     *      (2) 大西洋：右边界和下边界。从这两个边界搜索可以找到能够流向大西洋的点。
     *      (3) 搜索过程中需要记录每个单元可是否可以流向大西洋，是否可以流向太平洋。
     *      (4) 搜索结束后，遍历每个网格，如果一个网格从太平洋和大西洋都可以反向到达，则将该网格添加至答案中。
     * @param heights // 高于海平面的高度，即雨水在某位置的高度高于相邻位置，则该位置的雨水可以流向旁边位置
     * @return 既可以流向大西洋，又可以流向太平洋的 坐标集合
     */

    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // 四个方向
    int[][] heights;
    int m,n;


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length; // 行数
        this.n = heights[0].length; // 列数

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic  = new boolean[m][n];

        // 大西洋
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific); // 第一列，逐行dfs
        }
        for (int j = 1; j < n; j++) {
            dfs(0, j, pacific); // 第一行，逐列dfs
        }

        // 太平洋
        for (int i = 0; i < m; i++) {
            dfs(i, n-1, atlantic); // 最后一列，逐行dfs
        }
        for (int j = 0; j < n-1; j++) {
            dfs(m-1, j, atlantic); // 最后一行，逐列dfs
        }

        List<List<Integer>> result = new ArrayList<>(); // 结果集
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) { // 在大西洋和太平洋都可以到达
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    /**
     * 深度优先算法
     * @param row // 行
     * @param col // 列
     * @param ocean // 大西洋还是太平洋
     */
    public void dfs(int row, int col, boolean[][] ocean) {
        if(ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) { // 四个方向反向搜索
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // 如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow,newCol,ocean);
            }
        }
    }
}
