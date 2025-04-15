import java.util.*;

class Solution {

    private static int[] parent;

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            parent = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                union(wires[j][0], wires[j][1]);
            }

            int[] groupCount = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                int root = find(j);
                groupCount[root]++;
            }

            ArrayList<Integer> counts = new ArrayList<>();
            for (int count : groupCount) {
                if (count > 0) counts.add(count);
            }

            if (counts.size() == 2) {
                int diff = Math.abs(counts.get(0) - counts.get(1));
                minDiff = Math.min(minDiff, diff);
            }
        }

        return minDiff;
    }
}
