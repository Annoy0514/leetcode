package leetcode.排序;

/**
 * 给定一个节点数为n的无序单链表，对其按升序排序。
 */

public class Test3_单链表的排序 {
    /**
     * 归并排序
     * @param pHead1
     * @param pHead2
     * @return 排序好的头节点
     */
    // 1.合并两个有序的链表
    ListNode merge(ListNode pHead1, ListNode pHead2) {
        // 如果一个为空，直接返回另外一个
        if(pHead1 == null) {
            return pHead2;
        }
        if(pHead2 == null) {
            return pHead1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        // 如果两个链表都不为空
        while (pHead1 != null && pHead2 != null) {
            // 取较小的节点
            if(pHead1.val <= pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }
        // 如果哪个链表还有剩余，直接连接到后面
        if(pHead1 != null) {
            cur.next = pHead1;
        } else {
            cur.next = pHead2;
        }
        return head.next;
    }

    public ListNode sortInList (ListNode head) {
        // 链表为空或是只有一个元素时，直接就是有序的
        if(head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        // 右边指针到达末尾时，中间指针指向该段的中间
        while (right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        // 此时的左指针指向断开左右的分界节点
        left.next = null;
        // 分成两段排序，合并排序好的两段
        return merge(sortInList(head),sortInList(mid));
    }

}
