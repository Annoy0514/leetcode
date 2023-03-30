package leetcode.Tree;

public class Test6_另一棵树的子树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);

        root.left = root1;
        root.right = root2;

        TreeNode subroot = new TreeNode(1);
        TreeNode subroot1 = new TreeNode(2);
        TreeNode subroot2 = new TreeNode(3);

        subroot.left = subroot1;
        subroot.right = subroot2;

        System.out.println(isSubtree(root,subroot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // root已经遍历完成，说明没有相同的树
        if(root == null) {
            return false;
        }
        /**
         * 最终返回：
         *  1.root树和subRoot树相等。
         *  2.root树的左子树与subroot相同。
         *  3.root树的右子树与subroot相同。
         *  三种情况，满足其一即可。
         */
        return isSameTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    // 判断是否是同一棵树
    public static boolean isSameTree(TreeNode s, TreeNode t) {
        // 1.如果两个树同时为空，说明遍历到最后，两数相同
        if(s==null && t==null) {
            return true;
        }

        // 2.如果上面没有返回值，说明至少有一个没有为空(有可能两个都不为空)
        if(s==null || t==null) {
            return false;
        }

        // 3.如果判断到这一步，说明两者都不为空
        // 先序遍历
        if(s.val != t.val) {
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
}
