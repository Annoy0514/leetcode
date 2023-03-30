package leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 补充知识：
 *  1.前序遍历
 *      根 —— 左 —— 右
 *  2.中序遍历
 *      左 —— 根 —— 右
 */

public class Test7_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {

    }
    private static Map<Integer,Integer> indexMap;

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right) return null;

        // 前序遍历的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 获取左子树的节点数目
        int left_subtree_size = inorder_root - inorder_left;
        /**
         * 递归构造 左子树，并连接到根节点
         * 先序遍历中，从【 左边界+1 开始到 left_subtree_size 】个元素对应中序遍历中从【 左边界 开始到 根节点-1】的元素
         */
        root.left = myBuildTree(preorder, inorder, preorder_left+1, preorder_left+left_subtree_size, inorder_left, inorder_root-1);
        /**
         * 递归构造 右子树，并连接到根节点
         * 先序遍历中，从【 左边界+1+左子树节点个数 开始到 右边界 】个元素对应中序遍历中从【 根节点定位+1 开始到 右边界】的元素
         */
        root.right = myBuildTree(preorder, inorder, preorder_left+1+left_subtree_size, preorder_right, inorder_root+1, inorder_right);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        // 构造哈希映射,快速定位根节点位置
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            // 中序遍历中每个节点的值作为Key,索引位置作为value
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,length-1,0,length-1);
    }

//    public static TreeNode myBuildTree_2(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left,int inorder_right) {
//        /**
//         * 思路：
//         *  根据前序遍历的第一个节点【根节点】找到中序遍历中【根节点的位置】
//         */
//        int preorder_root = preorder_left;
//        // 中序遍历中定位根节点
//        int inorder_root = indexMap.get(inorder[preorder_root]);
//        // 构造根节点
//        TreeNode root = new TreeNode(preorder[preorder_root]);
//        // 获取左子树的节点个数
//        int left_subtree_size = inorder_root - inorder_left;
//        /**
//         * 递归构造左子树，并连接到根节点
//         * 先序遍历中，从【左边界+1，左边界+左子树节点个数（left_subtree_size）】 与中序遍历中【左边界，根节点位置-1】对应为左子树
//         */
//        root.left = myBuildTree_2(preorder,inorder,preorder_left+1,preorder_left+left_subtree_size,inorder_left,inorder_root-1);
//        /**
//         * 递归构造右子树，并连接到根节点
//         * 先序遍历中，从【左边界+左子树节点个数+1，右边界】 与中序遍历中 【根节点位置+1，右边界】对应为右子树
//         */
//        root.right = myBuildTree_2(preorder,inorder,preorder_left+1+left_subtree_size, preorder_right,inorder_root+1,inorder_right);
//        return root;
//    }
}
