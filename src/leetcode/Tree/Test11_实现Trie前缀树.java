package leetcode.Tree;

public class Test11_实现Trie前缀树 {
    class Trie{
        class TrieNode{
            boolean isEnd;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if(node.next[c-'a'] != null) {
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.next[c-'a'];
                if(node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if(node.next[c-'a'] == null) {
                    return false;
                }
                node = node.next[c-'a'];
            }
            return true;
        }
    }
}
