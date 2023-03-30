package leetcode.Tree;

/**
 * 226. 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */

public class Test3_InvertBinaryTree {
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

        System.out.println(invertTree(root));
    }

    /**
     * 递归方法
     * @param root
     * @return
     */

    // 1.前序遍历——从上往下
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        // temp暂存右子树
        TreeNode temp = root.right;
        // 左子树右子树交换
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }

    // 2.后序遍历——从下往上
    public static TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        TreeNode leftNode = invertTree2(root.left);
        TreeNode rightNode = invertTree2(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }
}
