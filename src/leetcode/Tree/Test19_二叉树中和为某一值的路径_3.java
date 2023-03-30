package leetcode.Tree;

/**
 * 给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum 。
 * 1.该题路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
 * 2.总节点数目为n
 * 3.保证最后返回的路径个数在整形范围内(即路径个数小于231-1)
 */

public class Test19_二叉树中和为某一值的路径_3 {
    private int res_num = 0;
    public int FindPath (TreeNode root, int sum) {
        // write code here
        if(root == null) return res_num;
        dfs(root,sum);
        // 以当前节点的子节点，作为新的根节点进行查找
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        return res_num;
    }

    /**
     * 题目要求不需要从根节点开始，也不需要在叶子节点结束
     * 需要从根节点开始，一个节点一个节点的进行深度遍历。
     * 向下遍历的过程中，遇到一个节点就将sum减去节点值再往下。
     * 剩余的sum等于当前节点值则找到一种情况。(sum-root.val==0)
     * @param root
     * @param sum
     */
    public void dfs(TreeNode root, int sum) {
        if(root == null) return;
        sum -= root.val;
        if(sum == 0) {
            res_num++;
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}
