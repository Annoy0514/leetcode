package leetcode.LinkedList;

public class Test11_删除链表的节点 {
    public ListNode deleteNode (ListNode head, int val) {
        if(head == null) return null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }
}
