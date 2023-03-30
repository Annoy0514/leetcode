package leetcode.Tree;

import java.util.ArrayList;

/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 * 下图为一棵有9个节点的二叉树。树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
 */

public class Test17_二叉树的下一个结点 {
    static ArrayList<TreeLinkNode> inorder_tree = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root = getRoot(pNode);
        buildTree(root);
        for (int i = 0; i < inorder_tree.size()-1; i++) {
            if(pNode == inorder_tree.get(i)) {
                return inorder_tree.get(i+1); // 返回中序遍历结果的下一个节点
            }
        }
        return null;
    }

    // 查找父节点
    public TreeLinkNode getRoot(TreeLinkNode pNode) {
        while (pNode.next != null) {
            pNode = pNode.next;
        }
        return pNode;
    }

    // 中序遍历构建二叉树，将中序遍历的结果存储下来
    public void buildTree(TreeLinkNode root) {
        if(root != null) {
            buildTree(root.left);
            inorder_tree.add(root);
            buildTree(root.right);
        }
    }
}
