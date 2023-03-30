package leetcode.LinkedList;

public class Test5_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        for (ListNode cur = removeNthFromEnd(n1,1); cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    /**
     * 如果要删除节点y, 需要知道节点y的前驱节点x, 并将x的指针指向y的后续节点。
     * 头节点不存在前驱节点，通过增设 哑节点 ,那么头节点的前驱节点就是哑节点本身，无需对头节点进行特殊处理。
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0,head); // 设置哑节点，为了处理删除头节点的情况
        ListNode cur = temp;

        int length = getLength(head); // 计算链表长度

        /**
         * 删除倒数第 n 个节点，就是删除 length-n+1 个节点。
         */
        for (int i = 1; i < length - n +1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next; // 跳过被删除的节点
        return temp.next; // 由于temp是哑节点，所以返回结果为 temp.next
    }

    public static int getLength(ListNode head) {
        int length = 0;
        ListNode len = head;
        while (len != null){
            length++;
            len = len.next;
        }
        return length;
    }
}
