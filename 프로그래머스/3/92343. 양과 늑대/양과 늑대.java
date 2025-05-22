import java.util.*;

class Solution {
    List<Integer>[] tree;
    int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        tree = new List[info.length];
        for (int i = 0; i < info.length; i++) tree[i] = new ArrayList<>();
        for (int[] edge : edges) tree[edge[0]].add(edge[1]);

        dfs(0, 0, 0, List.of(0), info);
        return maxSheep;
    }

    private void dfs(int curr, int sheep, int wolf, List<Integer> available, int[] info) {
        if (info[curr] == 0) sheep++;
        else wolf++;

        if (wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);

        List<Integer> next = new ArrayList<>(available);
        next.remove(Integer.valueOf(curr));
        next.addAll(tree[curr]);

        for (int node : next) {
            dfs(node, sheep, wolf, next, info);
        }
    }
}
