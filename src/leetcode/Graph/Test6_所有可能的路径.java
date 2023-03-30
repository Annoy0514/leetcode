package leetcode.Graph;

import java.util.*;

public class Test6_所有可能的路径 {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
    private static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private static Deque<Integer> stack = new ArrayDeque<Integer>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length-1);
        return ans;
    }

    public static void dfs(int[][] graph, int x, int n) {
        if(x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i : graph[x]) {
            stack.offerLast(i);
            dfs(graph,i,n);
            stack.pollLast();
        }
    }
}
