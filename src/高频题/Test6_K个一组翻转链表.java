package 高频题;

public class Test6_K个一组翻转链表 {
    /**
     * 方法一
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 循环k次
            for(int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if(end == null) {
                break;
            }
            // 记录下end.next，方便连接
            ListNode next = end.next;
            // 记录要反转的链表的头节点
            ListNode start = pre.next;
            // 反转链表
            pre.next = reverse(start);
            // 翻转后头节点变到最后。通过.next把断开的链表重新链接
            start.next = next;
            // 将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            // 翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    /**
     * 方法二
     */
    public ListNode reverseKGroup_2(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 判断剩余长度是否大于等于k
            for(int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head,tail);
            head = reverse[0];
            tail = reverse[1];
            //子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }
}
