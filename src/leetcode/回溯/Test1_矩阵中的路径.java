package leetcode.回溯;

/**
 * 请设计一个函数，用来判断在一个n乘m的矩阵中是否存在一条包含某长度为len的字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如:
 *      a b c e
 *      s f c s
 *      a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

public class Test1_矩阵中的路径 {
    public boolean hasPath (char[][] matrix, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                // 从[i,j]坐标开始查询
                if(dfs(matrix, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] matrix, char[] word, int i, int j, int index) {
        /**
         * 1.边界判断，如果越界直接返回false。
         * index 定位查找到字符串word的第几个字符，如果这个字符不等于matrix[i][j],说明这个坐标所在的条路走不通，返回false。
         */
        if(i > matrix.length || i < 0 || j > matrix[0].length || j < 0 || matrix[i][j] != word[index]) {
            return false;
        }

        /**
         * 2.如果word中的每个字符都遍历到了，返回true
         */
        if(index == word.length - 1) {
            return true;
        }

        /**
         * 3.记录当前坐标，用于后续对该坐标进行复原
         */
        char tmp = matrix[i][j];
        // 修改当前坐标的值
        matrix[i][j] = '.';

        /**
         * 4.递归查找，遍历该节点的四个方向（上下左右）
         *
         */
        boolean res = dfs(matrix, word, i+1, j, index+1)
                || dfs(matrix, word, i-1, j, index+1)
                || dfs(matrix, word, i, j-1, index+1)
                || dfs(matrix, word, i, j+1, index-1);

        /**
         * 5.遍历完成后，将该坐标进行复原
         */
        matrix[i][j] = tmp;
        return res;
    }
}
