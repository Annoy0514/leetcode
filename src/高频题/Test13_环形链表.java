package 高频题;

import java.util.HashSet;
import java.util.List;

public class Test13_环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode node =  head;
        HashSet<ListNode> nodes = new HashSet<>();
        while (node != null) {
            if(!nodes.add(node)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
