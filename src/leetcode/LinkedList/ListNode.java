package leetcode.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode head) {
        this.val = val;
        this.next = head;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
