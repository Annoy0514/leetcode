package leetcode.LinkedList;

import java.util.Stack;

/**
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 */
public class Test7_两个链表的第一个公共结点 {
    /**
     * 思路：
     *      将两个链表存入到两个栈中
     *      如果存在共同节点的话，那么两个链表从尾部从后向前到该共同节点，都是一样的
     *      根据栈的性质，比较出栈的值，当两个栈出栈的元素相同时，即为相同的节点。
     *      一直到出栈元素不相同，则上一个出栈的节点就是第一个公共节点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }

        Stack<ListNode> stack_1 = new Stack<>();
        Stack<ListNode> stack_2 = new Stack<>();

        while (pHead1 != null) {
            stack_1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack_2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode commonNode = null;

        while (!stack_1.isEmpty() && !stack_2.isEmpty() && stack_1.peek() == stack_2.peek()) {
            stack_2.pop();
            commonNode = stack_1.pop();
        }

        return commonNode;
    }
}
