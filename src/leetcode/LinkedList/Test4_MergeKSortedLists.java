package leetcode.LinkedList;

/**
 * 23. 合并 K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Test4_MergeKSortedLists {

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

        ListNode list3 = new ListNode(3);
        ListNode j2 = new ListNode(6);
        ListNode j3 = new ListNode(9);
        list2.next = j2;
        j2.next = j3;

        ListNode[] lists = new ListNode[3];
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        for (ListNode cur = mergeKLists(lists); cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    /**
     * 1.使用 顺序合并 的方法
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }

    /**
     * 2.使用 分治 的方法
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        } else if(lists.length == 1) {
            return lists[0];
        } else if (lists.length == 2) {
            return mergeTwoLists(lists[0],lists[1]);
        }

        // 分治方法
        int mid = lists.length / 2;

        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int k = mid,j = 0; j < lists.length - mid; j++,k++) {
            l2[j] = lists[k];
        }

        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }

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
