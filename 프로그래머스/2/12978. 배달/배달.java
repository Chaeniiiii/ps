import java.util.*;

class Solution {
    
    private static Map<Integer, ArrayList<Road>> map;
    private static int[] minDist;
    private static int total;
    
    private static class Road {
        int node;
        int dist;

        private Road(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        map = new HashMap<>();
        
        for (int[] info : road) {
            map.computeIfAbsent(info[0], v -> new ArrayList<>()).add(new Road(info[1], info[2]));
            map.computeIfAbsent(info[1], v -> new ArrayList<>()).add(new Road(info[0], info[2]));
        }

        minDist = new int[N + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        total = 0;

        dfs(1, K, 0);
        
        for (int i = 1; i <= N; i++) {
            if (minDist[i] <= K) total++;
        }
        
        return total;
    }
    
    private static void dfs(int current, int K, int cnt) {
        // 현재까지 거리가 이미 저장된 최소 거리보다 길면 중단
        if (cnt >= minDist[current]) return;

        minDist[current] = cnt;

        for (Road next : map.get(current)) {
            int nextDist = cnt + next.dist;
            if (nextDist <= K) {
                dfs(next.node, K, nextDist);
            }
        }
    }
}
