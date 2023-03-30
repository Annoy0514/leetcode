package leetcode.Tree;

/**
 * 124. 二叉树中的最大路径和
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Test4_BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        Test4_BinaryTreeMaximumPathSum test4 = new Test4_BinaryTreeMaximumPathSum();
        System.out.println(test4.maxPathSum(root));
    }

    /**
     * 路径分析
     *  将树拆解为一个个的有 根、左节点、右节点 的小树
     *  计算一个三节点的小树的结果为：
     *      (1) 根 + 左 + 右
     *      (2) 根 + 左
     *      (3) 根 + 右
     *      (4) 根
     *      (5) 左
     *      (6) 右
     *  其中只有 2 3 4 可以往上累加(加到父节点)，构成路径
     *  1 累加会出现分叉
     *  5 6 累加会出现断层
     *  情况1: 1，5，6不可累加的最大值
     *  情况2: 遍历计算 2，3，4可累加的最大值
     *  返回结果: 情况1 和 情况2 中的最大值
     * @param root
     * @return
     */
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 计算 左分支 最大值
        int leftMax = Math.max(0,dfs(root.left));
        // 计算 右分支 最大值
        int rightMax = Math.max(0,dfs(root.right));
        // left->root->right 作为路径与已经计算过的最大值进行比较 1，5，6
        max = Math.max(max, root.val+leftMax+rightMax);
        // 返回经过root的单边最大分支给当前root的父节点计算使用 2，3，4
        return root.val + Math.max(leftMax,rightMax);
    }
}
