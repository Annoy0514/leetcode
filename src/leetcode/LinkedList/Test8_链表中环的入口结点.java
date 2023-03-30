package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Test8_链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 排除特殊情况
        if(pHead == null) {
            return null;
        }
        // 使用集合set，将节点都存入到set中，如果存在重复的节点，说明存在环，则第一个重复的节点就是环的入口
        Set<ListNode> set = new HashSet<>();
        while (pHead != null) {
            // 如果向set中添加节点失败，说明重复，则存在环
            if(!set.add(pHead)) {
                return pHead;
            }
            // 将当前节点存入到set中
            pHead = pHead.next;
        }
        return null;
    }
}
