package leetcode.Tree;

/**
 * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 */

public class Test16_判断是否是平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        // 1.为空树
        if(root == null) return true;

        // 2.不为空树
        // 2.1 判定左右子树深度差是否小于等于1
        // 2.2 判定左右子树的子树是否满足平衡二叉树的条件
        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftHeight = TreeDepth(root.left);
            int rightHeight = TreeDepth(root.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
