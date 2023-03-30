package 高频题;

import java.util.HashMap;
import java.util.Map;

public class Test3_LRU缓存机制 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    /**
     * LRU缓存机制可以通过 【哈希表+双向链表】 实现，用一个哈希表和一个双向链表维护在缓存中的键值对。
     *  - 双向链表：按照使用顺序存储键值对，靠近头节点的是近期使用的，靠近尾节点的是最久未使用的。
     *      双向链表的实现可以使用一个伪头部和一个伪尾部。
     *  - 哈希表： 普通的哈希映射(HashMap)通过缓存数据的键映射双链表中的位置。
     * 首先使用哈希表进行定位，找出缓存项在双向链表中的位置，随后将其移动到双向链表的头部，即可在 O(1) 的时间内完成 get 或者 put 操作。
     * @param capacity
     */
    public Test3_LRU缓存机制(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * get操作，首先判断 key 是否存在：
     *  - 如果 key 不存在，则返回 -1。
     *  - 如果 key 存在，则 key 对应的节点是近期使用的节点，需要定位其在双向链表中的位置，然后将其移动到表头，最后返回该节点。
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        // key不存在
        if(node == null) {
            return -1;
        }
        // key存在,将对应节点移动到双向链表头部，并返回该节点值。
        moveToHead(node);
        return node.value;
    }

    /**
     * put操作，首先判断key是否存在：
     *  - 如果key不存在，则使用 key和value 创建一个新节点，在双向链表的头部添加该节点。然后在哈希表中添加该节点的映射。
     *      同时还需要判断是否超出双链表的容量。
     *      (1) 超出容量，删除双向链表的尾部节点，并删除哈希表中对应的项。
     *  - 如果key存在，先通过哈希表定位其在双链表中的位置，将其更新为新的value，然后将该节点移动到链表头部。
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 更新值
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 将节点移动至双向链表头部
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 将节点从双向链表中移除
     * @param node
     */
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将节点添加至双向链表头部
     * @param node
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除尾部节点，并返回该节点的值
     * @return
     */
    private DLinkedNode removeTail() {
        // 因为有伪尾部，所以删除的是伪尾部的前一个节点
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
