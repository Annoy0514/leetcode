package 高频题;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 */

public class Test1_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = res.next;
            res.next = tmp;
        }
        return res.next;
    }
}
