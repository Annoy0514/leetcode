package leetcode.LinkedList;

import java.util.List;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 举例:
 *  [1,2,3,4] ---> [1,4,2,3]
 *  [1,2,3,4,5] ---> [1,5,2,4,3]
 */

public class Test6_ReorderList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        reorderList(n1);

        for (ListNode cur=n1; cur != null; cur=cur.next){
            System.out.println(cur.val);
        }
    }

    public static void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode temp = head;
        while (temp.next.next!=null) {
            temp = temp.next;
        }
        ListNode insertNode = temp.next; // 定位到最后一个，当作插入点
        temp.next = null; // 倒数第二位与最后一位断开
        insertNode.next = head.next; // 最后一位接到第二位之前
        head.next = insertNode; // 第一位将上一步的链接起来
        reorderList(insertNode.next); // 递归调用该过程
    }
}
