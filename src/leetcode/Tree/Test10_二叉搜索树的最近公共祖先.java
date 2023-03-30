package leetcode.Tree;

public class Test10_二叉搜索树的最近公共祖先 {
    private static TreeNode res;
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
        /**
         *          4
         *         /  \
         *        1    6
         *            / \
         *           5   7
         */
//        System.out.println(kthSmallest(root1,2));
        System.out.println(lowestCommonAncestor(root1,node1,node5).val);
    }

    /**
     * 利用二叉搜索树的特点：
     * 如果p、q的值都小于root，说明p q 肯定在root的左子树中;
     * 如果p q都大于root，说明肯定在root的右子树中;
     * 如果一个在左一个在右 则说明此时的root记为对应的最近公共祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        return res;
    }

    public static void lca(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val - p.val) * (root.val - q.val) <= 0) { // 两个节点在root的一左一右或者就是root，则根节点为 root
            res = root;
        } else if(root.val < p.val && root.val < q.val) { // 两个节点的值都大于root的值，说明在右子树，继续在右子树查找
            lca(root.right,p,q);
        } else { // 两个节点的值都小于root的值，说明在左子树，继续在左子树查找
            lca(root.left,p,q);
        }
    }
}
