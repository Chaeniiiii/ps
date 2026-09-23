import java.util.*;

class Solution {

    private int result;
    private int[] info;
    private ArrayList<Integer>[] arr;

    public int solution(int[] info, int[][] edges) {
        
        this.info = info;
        int n = info.length;
        
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) arr[i] = new ArrayList<>();
        for (int[] edge : edges) arr[edge[0]].add(edge[1]);

        ArrayList<Integer> nextList = new ArrayList<>();
        nextList.add(0);  // 시작 노드
        dfs(0, 0, 0, nextList);
        return result;
    }

    private void dfs(int st, int sheep, int wolf, ArrayList<Integer> nxt) {
        
        if (info[st] == 0) sheep++;
        else wolf++;

        if (wolf >= sheep) return;

        result = Math.max(result, sheep);

        ArrayList<Integer> nextNode = new ArrayList<>(nxt);
        nextNode.remove(Integer.valueOf(st));
        nextNode.addAll(arr[st]);

        for (int node : nextNode) {
            dfs(node, sheep, wolf, nextNode);
        }
    }
}
