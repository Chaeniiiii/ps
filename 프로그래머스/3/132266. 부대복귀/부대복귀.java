import java.util.*;

class Solution {
    
    private List<Integer>[] graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        //1. 그래프 만들기
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] r : roads){
            int v = r[0];
            int u = r[1];
            graph[v].add(u);
            graph[u].add(v);
        }
        
        //2. 다익스트라 실행
        int[] dist = dijkstra(n,destination);
        
        int[] result = new int[sources.length];
        //3.최단시간 구하기
        for(int i = 0; i < sources.length; i++){
            if(dist[sources[i]] == Integer.MAX_VALUE) result[i] = -1;
            else result[i] = dist[sources[i]];
        }
        
        return result;
        
    }
    
    private int[] dijkstra(int n, int dt){
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[dt] = 0;
        
        boolean[] visited = new boolean[n+1];
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{dt,0});
        
        while(!pq.isEmpty()){
            
            int[] now = pq.poll();
            int node = now[0];
            int d = now[1];
            
            visited[node] = true;
            
            for(int child : graph[node]){
                if(visited[child]) continue;
                if(d + 1 < dist[child]){
                    dist[child] = d + 1;
                    pq.add(new int[]{child,dist[child]});
                }
            }
            
        }
        
        return dist;
        
        
    }
}