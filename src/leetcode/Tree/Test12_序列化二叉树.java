package leetcode.Tree;

public class Test12_序列化二叉树 {
    private int index = 0; // 序列的下标
    // 1.处理序列化的功能函数
    private void SerializeFunction(TreeNode root, StringBuilder str) {
        // 如果节点为空，表示左子节点或者右子节点为空，用#表示
        if(root == null) {
            str.append('#');
            return;
        }
        // 根节点
        str.append(root.val).append(',');
        // 左子树
        SerializeFunction(root.left, str);
        // 右子树
        SerializeFunction(root.right, str);
    }
    public String Serialize(TreeNode root) {
        // 空树情况
        if(root == null) {
            return "#";
        }
        StringBuilder res = new StringBuilder();
        SerializeFunction(root, res);
        // str转化为char
        return res.toString();
    }
    // 2.处理反序列化的功能函数
    private TreeNode DeserializeFunction(String str) {
        // 空节点情况
        if(str.charAt(index) == '#') {
            index++;
            return null;
        }
        // 数字转换
        int val = 0;
        // 遇到分隔符或是结尾
        while(str.charAt(index) != ',' && index != str.length()) {
            val = val * 10 + ((str.charAt(index)) - '0');
            index++;
        }
        TreeNode root = new TreeNode(val);
        // 遍历到序列的结尾
        if(index == str.length()) {
            return root;
        } else {
            index++;
        }
        // 反序列化
        root.left = DeserializeFunction(str);
        root.right = DeserializeFunction(str);
        return root;
    }
    public TreeNode Deserialize(String str) {
        // 空序列为空树
        if(str == "#") return null;
        TreeNode res = DeserializeFunction(str);
        return res;
    }
}
