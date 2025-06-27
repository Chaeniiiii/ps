import java.util.*;

class Solution {
    
    private static final int INF = Integer.MAX_VALUE;
    
    private static class Node{
        int nxt;
        int cost;
        
        private Node(int nxt, int cost){
            this.nxt = nxt;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        Map<Integer,ArrayList<Node>> graph = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] fare : fares){
            int v = fare[0];
            int u = fare[1];
            int t = fare[2];
            
            graph.get(v).add(new Node(u,t));
            graph.get(u).add(new Node(v,t));
            
        }
        
        int[] startDist = dijkstra(n,s,graph);
        int[] aDist = dijkstra(n,a,graph);
        int[] bDist = dijkstra(n,b,graph);
        
        int result = INF;

        for(int i = 1; i <=n; i++){
            
            int cnt = startDist[i] + aDist[i] + bDist[i];
            
            if(result > cnt){
                result = cnt;
            }
            
        }
        
        return result;
        
    }
    
    private static int[] dijkstra(int n, int st, Map<Integer,ArrayList<Node>> graph){
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Node(st,0));
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        dist[st] = 0;
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            for(Node node : graph.get(now.nxt)){
                
                int newCost = node.cost + dist[now.nxt];
                
                if(dist[node.nxt] > newCost){
                    dist[node.nxt] = newCost;
                    pq.add(new Node(node.nxt,dist[node.nxt]));
                }
                
            }
            
        }
        
        return dist;
        
    }
    
}