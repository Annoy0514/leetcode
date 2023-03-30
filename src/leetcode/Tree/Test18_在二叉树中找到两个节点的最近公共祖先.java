package leetcode.Tree;

import java.util.*;

public class Test18_在二叉树中找到两个节点的最近公共祖先 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // 记录遍历到的每个节点的父节点
        Map<Integer,Integer> parent_map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent_map.put(root.val,Integer.MIN_VALUE); // 根节点没有父节点，给其赋个初值
        queue.add(root);

        // 直到两个节点都到找
        while (!parent_map.containsKey(o1) || !parent_map.containsKey(o2)) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                // 左子节点不为空，则记录下该节点的父节点
                parent_map.put(node.left.val,node.val);
                // 将左子节点放入到队列中
                queue.add(node.left);
            }
            // 右子节点同理
            if(node.right != null) {
                parent_map.put(node.right.val,node.val);
                queue.add(node.right);
            }
        }
        Set<Integer> ancestors = new HashSet<Integer>(); // 创建一个祖先集合
        // 记录o1的祖先：从o1开始一直到根节点
        while (parent_map.containsKey(o1)) {
            ancestors.add(o1);
            o1 = parent_map.get(o1);
        }
        // 查找o1和他的祖先节点中是否包含o2，如果不包含的话再看是否包含o2的祖先节点
        while (!ancestors.contains(o2)) {
            o2 = parent_map.get(o2);
        }
        return o2;
    }
}
