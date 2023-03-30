package leetcode.Tree;

/**
 * 100. 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * https://leetcode-cn.com/problems/same-tree/
 */

public class Test2_SameTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root1.left = node1;
        root2.left = node1;
        node1.left = node2;
        node1.right = node4;
        node2.right = node5;
        node5.right = node6;

        System.out.println(isSameTree(root1,root2));
    }


    /**
     * 递归方法
     * 如果两个树相同，则他们的左子树和右子树都相同。
     * (1) p==null && q==null 表示已经遍历到两个树的叶子节点
     * (2) p==null || q==null 表示其中一个树遍历到叶子节点，另一个没有，说明不相同
     * (3) p.val != q.val 遍历到某个节点两者的值不相同，说明不相同
     * @param p
     * @param q
     * @return
     */

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if(p==null || q==null) return false;
        else if(p.val != q.val) return false;
        return (isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
    }
}
