package 高频题.牛客100.链表;


public class Test2_链表内指定区间翻转 {
//    public ListNode reverseBetween (ListNode head, int m, int n) {
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//        ListNode pre = dummyNode;
//        for (int i = 0; i < m - 1; i++) {
//            pre = pre.next;
//        }
//
//        ListNode cur = pre.next;
//        ListNode tmp;
//        for (int i = 0; i < n - m; i++) {
//            tmp = cur.next;
//            cur.next = tmp.next.next;
//            tmp.next = pre.next;
//            pre.next = tmp;
//        }
//        return dummyNode.next;
//    }

    public ListNode reverserBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        // 1.走left-1步到left的前一个节点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        // 2.走right-left+1步到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < n - m + 1; i++) {
            rightNode = rightNode.next;
        }

        // 3.截取一个子链表
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        // 4.切断连接
        pre.next = null;
        rightNode.next = null;

        // 5.子链表反转
        reverseLinkedList(leftNode);

        // 6.接回原来链表
        pre.next = rightNode;
        leftNode.next = cur;

        // 7.返回结果
        return dummyNode.next;
    }

    public static void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }
}
