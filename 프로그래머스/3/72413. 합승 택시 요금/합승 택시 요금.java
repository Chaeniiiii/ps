import java.util.*;

class Solution {
    
    private static final int MAX = Integer.MAX_VALUE;
    
    private static class Node{
        int num;
        int dist;
        
        private Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] graph = new int[n+1][n+1];
        
        //그래프 구성
        for(int[] fare : fares){
            int v = fare[0];
            int u = fare[1];
            int d = fare[2];
            
            graph[v][u] = d;
            graph[u][v] = d;
        }
        
        int[] tDist = dijkstra(n,graph,s);
        int total = MAX;
        
        for(int i = 1; i <= n ; i++){
            int[] alone = dijkstra(n,graph,i);
            int cnt = tDist[i] + alone[a] + alone[b];
            if(total > cnt){
                total = cnt;
            }
        }
        
        return total;
        
    }
    
    private int[] dijkstra(int n, int[][] graph, int st){
        
        PriorityQueue<Node> pq= new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Node(st,0));
        
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        
        Arrays.fill(dist,MAX);
        dist[st] = 0;
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            if(visited[now.num]){
                continue;
            }
            
            visited[now.num] = true;
            
            for(int i = 1; i <= n; i++){
                if(graph[now.num][i] == 0){
                    continue;
                }
                if(dist[i] > graph[now.num][i] + dist[now.num]){
                    dist[i] = graph[now.num][i] + dist[now.num];
                    pq.add(new Node(i,dist[i]));
                }
            }
        }        
        
        return dist;
        
    }
}