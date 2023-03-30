package leetcode.Tree;

public class Test13_二叉树的深度 {
    /**
     * 深度优先搜索
     * 知道左子树的深度和右子树的深度，最大深度即为 max(左子树深度，右子树深度) + 1(根节点)
     * 使用递归获取左右子树的深度，访问到空节点返回
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int leftHeight = TreeDepth(root.left);
            int rightHeight = TreeDepth(root.right);
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
