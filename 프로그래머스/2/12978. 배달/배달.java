import java.util.*;

class Solution {
    
    private class Node{
        int v;
        int d;
        
        private Node(int v, int d){
            this.v = v;
            this.d = d;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        //그래프 생성        
        Map<Integer,ArrayList<Node>> graph = new HashMap<>();
        for(int i = 0; i < road.length; i++){
            int[] r = road[i];
            int a = r[0];
            int b = r[1];
            int d = r[2];
            
            graph.computeIfAbsent(a, v -> new ArrayList<>()).add(new Node(b,d));
            graph.computeIfAbsent(b, v -> new ArrayList<>()).add(new Node(a,d));
        }
        
        //다익스트라 수행
        int[] result = dijkstra(N,graph,1);
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(result[i] <= K) cnt++;
        }
        
        return cnt;
        
    }
    
    private int[] dijkstra(int n,Map<Integer,ArrayList<Node>> graph, int st){
        
        int[] result = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.d - b.d);
        pq.add(new Node(st,0));
        visited[st] = true;        
        result[st] = 0;
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            visited[now.v] = true;
            
            
            for(Node child : graph.get(now.v)){
                if(visited[child.v]) continue;
                int cost = now.d + child.d;
                result[child.v] = Math.min(result[child.v],cost);
                pq.add(new Node(child.v,cost));
            }
        }
        
        return result;
        
    } 
    
}