package leetcode.Tree;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */

public class Test1_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        node1.left = node2;
        node1.right = node4;
        node2.right = node5;
        node5.right = node6;

        System.out.println(maxDepth(root));
    }

    /**
     * 深度优先搜索: 递归调用
     * 如果知道了左子树的深度 l 和右子树的深度 r ，二叉树的最大深度为 ： max(l,r) + 1[顶点]
     * 左子树和右子树的深度可以使用同种方法计算得出。
     * 递归访问到空节点时结束。
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
