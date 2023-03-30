package leetcode.Tree;

public class Test8_验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(6);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);

        root1.left = node1;
        root1.right = node2;
        node2.left = node4;
        node2.right = node5;
        System.out.println(isValidBST(root1));
    }

    /**
     * 二叉搜索树的性质
     *  (1) 如果该二叉树左子树不为空，则左子树上的所有节点的值均小于他的根节点。
     *  (2) 如果二叉树的右子树不为空，则右子树上的所有节点的值均大于他的根节点。
     *  (3) 左右子树也为二叉搜索树。
     *
     * 使用递归解决该问题
     *  (1)设计递归函数 isValidBst(root,lower,upper)
     *  (2)函数表示，以root为根节点的树，判断其子树的节点的值是否在(lower,upper)中
     *      如果不在范围内，说明不满足，返回false;
     *      如果在范围内，继续递归检查其左右子树是否满足，如果都满足，则是一颗二叉搜索树。
     *  (3) 在递归调用 左子树 的过程中，需要把上界 upper 更改为root.val，即调用 isValidBst(root.left,lower,root.val)，因为左子树的值都小于根节点的值。
     *  (4) 在递归调用 右子树 的过程中，需要把下界 lower 更改为root.val，即调用 isValidBst(root.right,root.val,upper)，因为右子树的值都大于根节点的值。
     *  ***注意***
     *  函数初始设置为 isValidBst(root,Long.MIN_VALUE,Long.MAX_VALUE)
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static boolean isValidBst(TreeNode root,long lower,long upper) {
        if(root == null) {
            return true;
        }
        // 根节点小于左子节点 或者 根节点大于右边的子节点，这两种情况不满足条件
        if(root.val<=lower || root.val>=upper) {
            return false;
        }
        return isValidBst(root.left, lower, root.val) && isValidBst(root.right,root.val,upper);
    }
}
