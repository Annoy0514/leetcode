package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Test1_CloneGraph {
    // 1.创建一个HashMap集合，用于存储遍历过的图节点
    static HashMap<Node, Node> visited = new HashMap<>();

    public static void main(String[] args) {

    }

    public static Node cloneGraph(Node node) {

        if(node == null) {
            return node;
        }

        // 如果该节点已经被访问过了，直接从哈希表中取出对应的克隆节点返回
        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点,为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList());
        // 哈希表存储
        visited.put(node,cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
