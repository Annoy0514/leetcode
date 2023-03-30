package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Test14_按之字形打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(); // 存储结果集
        TreeNode head = pRoot;

        // 如果为空，直接返回空的结果集
        if (head == null) {
            return res;
        }

        // 层序遍历
        Queue<TreeNode> temp = new LinkedList<>(); // 创建队列
        temp.offer(head); // 将头节点存入
        TreeNode p; // 遍历过程中的节点
        boolean flag = true; // 奇偶行的标识(偶数行左到右，奇数行右到左)

        while (!temp.isEmpty()) {
            // 记录二叉树中的某一行
            ArrayList<Integer> row = new ArrayList<>();
            int n = temp.size(); // 记录某一行的节点数
            // 奇数行反转，偶数行不反转
            flag = !flag;
            for (int i = 0; i < n; i++) {
                p = temp.poll(); // 出队，队头元素
                row.add(p.val); // 将出队的节点元素值存入到row中
                // 如果该节点的左孩子节点存在，则将左孩子节点存入到下一层次
                if (p.left != null) {
                    temp.offer(p.left);
                }
                // 如果右孩子存在，则将右孩子节点存入到下一个层次
                if (p.right != null) {
                    temp.offer(p.right);
                }
            }
            // 判断是奇数行还是偶数行:true-奇数行，false-偶数行
            if (flag) {
                Collections.reverse(row); // 反转该行存储的节点
            }
            res.add(row);
        }
        return res;
    }
}
