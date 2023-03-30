package leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Test10_删除链表中重复的结点 {
    /**
     * 1.直接比较删除的方法
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        // 空链表
        if(pHead == null) {
            return null;
        }
        ListNode res = new ListNode(0); // 先在链表前加一个表头
        res.next = pHead;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) { // 遇到具有相同值的节点
                int temp = cur.next.val;
                // 跳过所有相同值的节点
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }

    /**
     * 使用集合的方法
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication_2(ListNode pHead) {
        // 空链表
        if(pHead == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = pHead;
        // 1.第一遍遍历链表，统计所有节点值出现的次数
        while (cur != null) {
            if(map.containsKey(cur.val)) {
                map.put(cur.val, (int)map.get(cur.val) + 1);
            } else {
                map.put(cur.val,1);
            }
            cur = cur.next;
        }

        // 给链表加一个表头：应对链表中第一个元素存在重复的情况
        ListNode res = new ListNode(0);
        res.next = pHead;
        cur = res;
        // 2.再次遍历链表，找出统计次数为1的节点
        while (cur.next != null) {
            if(map.get(cur.next.val) != 1) { // 当前节点重复，跳过
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }
}
