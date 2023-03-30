package leetcode.LinkedList;

public class Test9_链表中倒数最后k个结点 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // 排除特殊情况
        if(pHead == null) {
            return pHead;
        }
        ListNode fast = pHead; // 快指针
        int i = 0;
        while (i < k) { // 快指针先走k步
            if(fast == null) return fast;
            fast = fast.next;
            i++;
        }
        ListNode slow = pHead; // 慢指针
        while (fast != null) { // 当快指针走到Null时，慢指针的位置就是倒数第k个节点
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
