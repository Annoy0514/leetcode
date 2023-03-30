package 高频题.牛客100.链表;

public class Test2_反转k个一组的链表 {
    public ListNode reverseKGroup (ListNode head, int k) {
        // 找到每次反转的尾部
        ListNode tail = head;
        // 遍历k次到尾部
        for (int i = 0; i < k; i++) {
            // 如果不足k就到了链表尾部，直接返回，不进行反转
            if(tail == null) return head;
            tail = tail.next;
        }
        // 反转时需要前序和当前节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 反转
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = reverseKGroup(tail,k);
        return pre;
    }
}
