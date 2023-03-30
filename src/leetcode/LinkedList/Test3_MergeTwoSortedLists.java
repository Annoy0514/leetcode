package leetcode.LinkedList;

import java.util.Arrays;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */

public class Test3_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        list1.next = n2;
        n2.next = n3;

        ListNode list2 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(5);
        list2.next = m2;
        m2.next = m3;

        for (ListNode cur = mergeTwoLists(list1,list2); cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    /**
     * 递归思想
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}
