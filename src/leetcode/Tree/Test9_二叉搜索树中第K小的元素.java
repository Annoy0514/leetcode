package leetcode.Tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test9_二叉搜索树中第K小的元素 {
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
        System.out.println(inorderTraversal(root1));
    }

    /**
     * 二叉树的中序遍历
     *  由于二叉搜索树的性质，中序遍历结果是一个有序数组。
     *  [中序遍历：左 -- 根 -- 右]
     *  返回第 k 小的元素就是中序遍历结果中第 k 个元素。
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(); // 实现一个栈
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root); // 栈顶添加元素
                root = root.left;
            }
            root = stack.pop(); // 移除栈顶元素
            --k;
            if(k==0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root!=null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
