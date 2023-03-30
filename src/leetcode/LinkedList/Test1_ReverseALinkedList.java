package leetcode.LinkedList;

/**
 * 206. 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Test1_ReverseALinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        for (ListNode cur = reverseList(n1); cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next; // 设置一个中间值存储当前结点指向的下一个节点
            cur.next = prev; // 改变引用指向的对象
            prev = cur; // 前驱节点后移
            cur = next; // 当前节点后移
        }
        return prev;
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public static ListNode reverseList_2(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = res.next;
            res.next = tmp;
        }
        return res.next;
    }
}
